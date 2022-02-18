package com.example.web_sell_fruit.configuration;


import com.example.web_sell_fruit.other.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvide")
public class JpaAuditingConfiguration {
    @Bean
    public AuditorAware<String> auditorProvide() {
        return new AuditorAwareImpl();
    }
}
