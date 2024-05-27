package hello.core.scan;

import hello.order.OrderService;
import hello.core.AutoAppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AutoAppConfigTest {
    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        OrderService memberService = ac.getBean(OrderService.class);
        Assertions.assertThat(memberService).isInstanceOf(OrderService.class);
    }
}