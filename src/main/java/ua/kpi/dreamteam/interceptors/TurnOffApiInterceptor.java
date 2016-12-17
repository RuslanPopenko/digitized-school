package ua.kpi.dreamteam.interceptors;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by ruslan on 17.12.16.
 */
public class TurnOffApiInterceptor extends HandlerInterceptorAdapter{

    //Boolean
    public static final String TURN_OFF_API_PARAMETER_NAME = "turnOffApi";
    //Integer
    public static final String ATTEMPTS_PARAMETER_NAME = "attemptsApiAccess";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(true);

        Boolean turnOffApi = (Boolean) session.getAttribute(TURN_OFF_API_PARAMETER_NAME);

        Integer attemptsApiAccess = (Integer) session.getAttribute(ATTEMPTS_PARAMETER_NAME);

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        boolean isApiHandler = handlerMethod.getBeanType().getSimpleName().endsWith("RestControllerImpl");

        //simulate internal server error
        if (isApiHandler && Objects.nonNull(turnOffApi) && turnOffApi) {
            if (Objects.nonNull(attemptsApiAccess)) {
                attemptsApiAccess--;
                session.setAttribute(ATTEMPTS_PARAMETER_NAME, attemptsApiAccess);
                if (attemptsApiAccess > 0) {
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    return false;
                } else {
                    session.setAttribute(TURN_OFF_API_PARAMETER_NAME, false);
                    return true;
                }
            }
        }

        return true;
    }
}
