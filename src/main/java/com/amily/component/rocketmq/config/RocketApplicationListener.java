package com.amily.component.rocketmq.config;

import com.amily.component.rocketmq.RocketMqInitializeCondition;
import com.amily.component.rocketmq.consumer.RocketMqConsumerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Conditional;


/**
 * @author lizhuo
 * @since 2019/1/4 下午10:14
 **/
@Slf4j
@Conditional(RocketMqInitializeCondition.class)
public class RocketApplicationListener implements ApplicationRunner {

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
        RocketMqConsumerConfig consumer = context.getBean(RocketMqConsumerConfig.class);
        consumer.start();
    }
}