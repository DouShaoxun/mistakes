package cn.cruder.mistakes;

import cn.cruder.mistakes.service.PrototypeTestService;
import cn.cruder.mistakes.util.SpringContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: cruder
 * @Date: 2022/03/27/20:29
 */
@SpringBootTest
public class PrototypeTest {
    @Autowired
    private PrototypeTestService prototypeTestService;
    @Autowired
    private SpringContextUtil springContextUtil;

    @Test
    void testPrototype_1() throws InterruptedException {
        // 虽然是原型,但是只有在getBean的时候才会创建新对象
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            try {
                prototypeTestService.test("tom");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }, "tom thread").start();
        new Thread(() -> {
            try {
                prototypeTestService.test("Jan");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }, "Jan thread").start();
        countDownLatch.await();
    }


    @Test
    void testPrototype_2() throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            try {
                // 直接从容器中获取bean
                PrototypeTestService bean = springContextUtil.getSpringApplicationContext().getBean(PrototypeTestService.class);
                bean.test("tom");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }, "tom thread").start();


        new Thread(() -> {
            try {
                // 直接从容器中获取bean
                PrototypeTestService bean = springContextUtil.getSpringApplicationContext().getBean(PrototypeTestService.class);
                bean.test("Jan");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }, "Jan thread").start();

        countDownLatch.await();
    }

}
