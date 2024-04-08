package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;


public class ConfigurationTest {
    @Test
    void configuration() {
          /**
           * TEST CASE 1
           * */
//        MyConfig myConfig = new MyConfig();
//        Bean1 bean1 = myConfig.bean1();
//        Bean2 bean2 = myConfig.bean2();
//
//        assertThat(bean1.common).isSameAs(bean2.common);

        /**
         * TEST CASE 2
         * */
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
//        ac.register(MyConfig.class);
//        ac.refresh();
//
//        Bean1 bean1 = ac.getBean(Bean1.class);
//        Bean2 bean2 = ac.getBean(Bean2.class);
//
//        assertThat(bean1.common).isSameAs(bean2.common);
        // 테스트 통과

          /**
           * TEST CASE 3
           * */
//        MyConfigProxy myConfigProxy = new MyConfigProxy();
//        Bean1 bean1 = myConfigProxy.bean1();
//        Bean2 bean2 = myConfigProxy.bean2();
//
//        assertThat(bean1.common).isSameAs(bean2.common);
    }

    static class MyConfigProxy extends MyConfig {
        private Common common;

        @Override
        Common common() {
            if (this.common == null) this.common = super.common();

            return this.common;
        }
    }

    @Configuration
    static class MyConfig {
        private int cnt;
        @Bean
        Common common() {
            cnt++;
            System.out.println("new Common() : "+cnt+"회 호출");
            Common com = new Common();
            System.out.println("Common 주소 : "+com);
            return com;
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }

        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    static class Bean1 {
        private final Common common;

        Bean1(Common common) {
            System.out.println("Bean1's common : "+common);
            this.common = common;
        }
    }

    static class Bean2 {
        private final Common common;

        Bean2(Common common) {
            System.out.println("Bean2's common : "+common);
            this.common = common;
        }
    }
}
