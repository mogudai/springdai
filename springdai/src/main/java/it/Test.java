package it;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        new Test().shouldAnswerWithTrue();
    }


    public void shouldAnswerWithTrue()
    {
        // 手动创建对象
//        DemoImpl d = new DemoImpl();
//        d.example();

        // spring自动创建对象
        // 1.指定spring配置文件的名称
        String config = "beans.xml";
        // 2.创建表示spring容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 3.从容器中获取对象getBean(id)
        DemoImpl d = (DemoImpl) ac.getBean("demo");
        // 4.使用对象
        d.example();
    }
}
