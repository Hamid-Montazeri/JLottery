package ir.mapsa.jlottery.jlottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class JLotteryApplication {

    public static void main(String[] args) {
        SpringApplication.run(JLotteryApplication.class, args);
    }

}
