package com.theironyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jenniferchang on 10/3/16.
 */
@Controller
@EnableAutoConfiguration
public class WeathersController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

}
