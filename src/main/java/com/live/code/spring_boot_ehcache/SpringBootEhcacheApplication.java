package com.live.code.spring_boot_ehcache;

import com.live.code.spring_boot_ehcache.model.AppConfig;
import com.live.code.spring_boot_ehcache.service.ConfigService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
@EnableCaching
public class SpringBootEhcacheApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEhcacheApplication.class, args);
    }

    private final ConfigService configService;

    private final AppConfig updatedAppConfig = AppConfig.builder()
            .key("IS_AUTO_START")
            .value("FALSE")
            .build();

    @Override
    public void run(String... args) throws Exception {
        log.info("======================== START ========================");
        log.info("[FIRST] time to get IS_AUTO_START value");
        log.info("IS_AUTO_START got --> {}", configService.getConfig("IS_AUTO_START"));
        log.info("[SECOND] time to get IS_AUTO_START value");
        log.info("IS_AUTO_START got --> {}", configService.getConfig("IS_AUTO_START"));
        configService.updateConfig(updatedAppConfig);
        log.info("[THIRD] time to get IS_AUTO_START value (After config update)");
        log.info("IS_AUTO_START got --> {}", configService.getConfig("IS_AUTO_START"));
        log.info("======================== END ========================");
    }
}
