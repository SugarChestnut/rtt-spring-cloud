package cn.rentaotao.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
        System.out.println(ConsumerApplication.class.getName());
        System.out.println(ConsumerApplication.class.getSimpleName());
        System.out.println(ConsumerApplication.class.getCanonicalName());
    }
}
