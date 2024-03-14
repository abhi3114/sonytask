package org.sonytask.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class BasicErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        return "Error handling logic goes here";
    }


    public String getErrorPath() {
        return "/error";
    }
}
