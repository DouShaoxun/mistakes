package cn.cruder.mistakes.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: cruder
 * @Date: 2022/04/02/14:46:03
 */
@Service
@Slf4j
public class HelloService {

    public void sayHello() {
        log.info(this + "\thello!");
    }
}
