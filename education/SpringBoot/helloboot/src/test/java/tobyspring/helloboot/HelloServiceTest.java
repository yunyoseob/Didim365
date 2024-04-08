package tobyspring.helloboot;

import tobyspring.helloboot.ComplexHelloService;
import tobyspring.helloboot.SimpleHelloService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {
    @Test
    void simpleHelloService(){
        System.out.println("==== simpleHelloService ====");
        SimpleHelloService helloService = new SimpleHelloService();

        String ret = helloService.sayHello("Test");
        // assertThat(ret).isEqualTo("Simple HelloTest");
    }

    @Test
    void complexHelloService(){
        System.out.println("==== complexHelloService ====");
        ComplexHelloService helloService = new ComplexHelloService();

        String ret = helloService.sayHello("Test");
        // assertThat(ret).isEqualTo("Complex HelloTest");
    }
}
