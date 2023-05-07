package tobyspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;


public class ConfigurationTest {
    @Test
    void configuration() {
        // isSameAs : 같은 오브젝트인지 주소값까지 비교
        MyConfig myConfig = new MyConfig();
        Bean1 bean1 = myConfig.bean1();
        Bean2 bean2 = myConfig.bean2();

        assertThat(bean1.common).isSameAs(bean2.common);
        /**
         * java.lang.AssertionError:
         * Expecting actual:
         *   tobyspring.helloboot.Common@25a65b77
         * and actual:
         *   tobyspring.helloboot.Common@2ed0fbae
         * to refer to the same object
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
    }

    @Test
    void proxyCommonMethod() {
        MyConfigProxy myConfigProxy = new MyConfigProxy();
        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        assertThat(bean1.common).isSameAs(bean2.common);
        // 테스트 통과
    }

    static class MyConfigProxy extends MyConfig {
        private Common common;

        @Override
        Common common() {
            if (this.common == null) this.common = super.common();

            return this.common;
        }
    }

    @Configuration(proxyBeanMethods = false)
    static class MyConfig {
        @Bean
        Common common() {
            return new Common();
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
            this.common = common;
        }
    }

    static class Bean2 {
        private final Common common;

        Bean2(Common common) {
            this.common = common;
        }
    }
}
