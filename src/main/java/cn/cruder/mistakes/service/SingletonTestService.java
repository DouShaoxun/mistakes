package cn.cruder.mistakes.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 单例
 * <p/>
 * spring默认{@link ConfigurableBeanFactory#SCOPE_SINGLETON}
 *
 * @Author: cruder
 * @Date: 2022/03/27/20:09
 */
@Service
@Slf4j
public class SingletonTestService {

    private String name;

    public void test(String pName) throws InterruptedException {
        name = pName;
        log.info("第一次打印, this:{}, name: {}", this, name);
        TimeUnit.SECONDS.sleep(3);
        log.info("第二次打印, this:{}, name: {}", this, name);
    }
}
