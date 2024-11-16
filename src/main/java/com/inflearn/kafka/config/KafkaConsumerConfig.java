//package com.inflearn.kafka.config;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.LongDeserializer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaConsumerConfig {
//
//    @Bean
//    public ConsumerFactory<String, Long> consumerFactory() {
//        Map<String, Object> config = new HashMap<>();
//
//
//        //컨슈머 정보 세팅
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); //서버정보
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_1"); //컨슈머 그룹 id
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); //Key 역직렬화 클래스
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class); // value 역직렬화 클래스
//
//        return new DefaultKafkaConsumerFactory<>(config);
//    }
//}
