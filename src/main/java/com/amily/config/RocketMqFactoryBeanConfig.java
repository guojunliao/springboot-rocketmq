package com.amily.config;

import com.amily.service.RocketMqConsumer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 创建生产者和消费者的工厂bean
 * @author lizhuo
 * @since 2019/1/4 下午10:14
 *
 **/
public class RocketMqFactoryBeanConfig {

    @Bean
    public RocketMqConsumer createConsumer(RocketMqProperties configuration, ApplicationContext context) throws Exception {
        System.out.println("=======createConsumer===");
        return new RocketMqConsumer(configuration, context);
    }

    @Bean
    public DefaultMQProducer createProducer(RocketMqProperties configuration) throws Exception {
        System.out.println("=======createProducer===");
        if (configuration.getNamesrvAddr() == null) {
            throw new IllegalArgumentException("rocketmq.nameSrvAddress 是必须的参数");
        }
        DefaultMQProducer producer = new DefaultMQProducer(configuration.getProducerId());
        producer.setNamesrvAddr(configuration.getNamesrvAddr());
        producer.setInstanceName(System.currentTimeMillis()+"");
        producer.start();
        return producer;
    }

}
