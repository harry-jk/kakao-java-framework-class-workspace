package kr.ac.jejunu.hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by jhkang on 5/13/16.
 */
public class AnnotationConfigApplicationContextTest {
    @Test
    public void applicationContext() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu");
        Hello hello = applicationContext.getBean("hello", Hello.class);
        assertThat(hello.sayHello(), is("Hello!!"));
    }

    @Test
    public void applicationContextUsingClass() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu");
        Hello hello = applicationContext.getBean(Hello.class);
        assertThat(hello.sayHello(), is("Hello!!"));
    }

    @Test
    public void applicationContextUsingDi() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("kr.ac.jejunu");
        HelloPerson helloPerson = applicationContext.getBean(HelloPerson.class);
        assertThat(helloPerson.sayHello(), is("Hello!! Harry"));
    }
}
