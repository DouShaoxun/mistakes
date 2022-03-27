package cn.cruder.mistakes;

import cn.cruder.mistakes.service.SingletonTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: cruder
 * @Date: 2022/03/27/20:25
 */
@SpringBootTest
public class SingletonTest {

    @Autowired
    private SingletonTestService singletonTestService;


    @Test
    void testSingleton() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            try {
                singletonTestService.test("tom");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }, "tom thread").start();
        new Thread(() -> {
            try {
                singletonTestService.test("Jan");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }, "Jan thread").start();
        countDownLatch.await();
    }


}