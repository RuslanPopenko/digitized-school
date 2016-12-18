package ua.kpi.dreamteam.restcontrollers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.dreamteam.interceptors.TurnOffApiInterceptor;

import javax.servlet.http.HttpSession;

/**
 * Created by ruslan on 17.12.16.
 */
@RestController
@RequestMapping("/exponentialbackoff")
public class ExponentialBackoffRestController {

    @RequestMapping(method = RequestMethod.POST)
    public String turnOffHandler(@RequestParam("attempts") Integer attempts,
                                 @RequestParam("url") String url,
                                 HttpServletRequest request){

        HttpSession session = request.getSession(true);
        session.setAttribute(TurnOffApiInterceptor.TURN_OFF_API_PARAMETER_NAME, true);
        session.setAttribute(TurnOffApiInterceptor.ATTEMPTS_PARAMETER_NAME, attempts);
        session.setAttribute(TurnOffApiInterceptor.URL_INTRCEPT_PARAMETER_NAME, url);

        return "OK";

    }

}
