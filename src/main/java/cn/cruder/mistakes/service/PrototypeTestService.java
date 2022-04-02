package cn.cruder.mistakes.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 原型
 * <p/>
 * prototype即原型模式，调用多少次bean，就实例化多少次。
 *
 * @Author: cruder
 * @Date: 2022/03/27/20:26
 */
@Service
@Slf4j
@org.springframework.context.annotation.Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeTestService {

    @Autowired
    HelloService helloService;
    private String name;

    public void test(String pName) throws InterruptedException {
        name = pName;
        helloService.sayHello();
        log.info("第一次打印, this:{}, name: {}", this, name);
        TimeUnit.SECONDS.sleep(3);
        log.info("第二次打印, this:{}, name: {}", this, name);

    }
}
