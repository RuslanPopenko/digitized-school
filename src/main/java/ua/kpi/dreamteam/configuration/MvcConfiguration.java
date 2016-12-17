package ua.kpi.dreamteam.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ua.kpi.dreamteam.interceptors.TurnOffApiInterceptor;

/**
 * Created by ruslan on 17.12.16.
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(turnOffApiInterceptor());
    }

    @Bean
    public HandlerInterceptor turnOffApiInterceptor() {
        return new TurnOffApiInterceptor();
    }
}
