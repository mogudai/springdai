package it;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        new Test().shouldAnswerWithTrue();
    }


    public void shouldAnswerWithTrue()
    {
        System.out.println(4);
    }
}
