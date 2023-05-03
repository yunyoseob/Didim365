package tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name){
        System.out.println("HelloController >> ");
        System.out.println("input name : "+name);
        return "Hello"+name;
    }
}
