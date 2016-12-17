package ua.kpi.dreamteam.restcontrollers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

        return "OK";

    }

}
