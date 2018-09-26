package com.springidol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = {"com.springidol"})
@EnableAspectJAutoProxy
public class BeanConfig {

    @Bean
    public Instrument guitar() {
        return new Guitar();
    }

    @Bean
    public Performer eddie() {
        return new Instrumentalist(guitar());
    }

    @Bean
    public AroundAudience audience() {
        return new AroundAudience();
    }

    @Bean
    public MindReader magician() {
        return new Magician();
    }

    @Bean
    public Thinkier volounteer() {
        return new Volounteer();
    }
}
