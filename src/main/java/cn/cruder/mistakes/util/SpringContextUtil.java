package cn.cruder.mistakes.util;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取上下文
 *
 * @Author: cruder
 * @Date: 2022/03/27/20:32
 */
@Component
@Getter
public class SpringContextUtil implements ApplicationContextAware {
    /**
     * Spring上下文
     */
    public ApplicationContext springApplicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.springApplicationContext = applicationContext;
    }
}
