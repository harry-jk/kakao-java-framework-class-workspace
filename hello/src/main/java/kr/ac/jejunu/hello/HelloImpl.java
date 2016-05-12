package kr.ac.jejunu.hello;

import org.springframework.stereotype.Component;

/**
 * Created by jhkang on 5/13/16.
 */
@Component("hello")
public class HelloImpl implements Hello{
    @Override
    public String sayHello() {
        return "Hello!!";
    }
}
