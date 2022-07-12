package com.zhx;

import com.zhx.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqProducerApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() { orderService.makeOrderDirect("12342","fsd234sfddf",2); }

    @Test
    void contextLoads1() {
        orderService.makeOrderFanout("12342","fsd234sfddf",2);
    }

    @Test
    void contextLoads2() {
        orderService.makeOrderTopic("12342","fsd234sfddf",2);
    }

    @Test
    void contextLoadsTTL() {
        orderService.makeOrderTTL( "12afdsf342","fsdas234sfddf",2);
    }

    @Test
    void contextLoadsTtlMessage() {
        orderService.makeOrderTtlMessage( "12afdsf342","fsdas234sfddf",2);
    }

}
