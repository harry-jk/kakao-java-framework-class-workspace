package kr.ac.jejunu.hello;

/**
 * Created by jhkang on 5/13/16.
 */
public class HelloPersonImpl implements HelloPerson {
    private String name;
    private Hello hello;

    @Override
    public String sayHello() {
        return hello.sayHello() + " " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }
}
