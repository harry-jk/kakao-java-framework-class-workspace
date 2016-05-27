package kr.ac.jejunu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jhkang on 2016-05-27.
 */
@Controller
public class HelloController {
    @RequestMapping("/spring/hello")
    public void hello() {

    }
}
