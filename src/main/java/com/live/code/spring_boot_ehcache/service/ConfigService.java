package com.live.code.spring_boot_ehcache.service;

import com.live.code.spring_boot_ehcache.model.AppConfig;
import com.live.code.spring_boot_ehcache.repository.ConfigRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ConfigService {

    private final ConfigRepository configRepository;

    @Cacheable(value = "config", key = "#key")
    public String getConfig(String key) {
        log.info("GetConfig without Ehcache");
        return configRepository.findByKey(key).getValue();
    }

    @CacheEvict(value = "config", allEntries = true)
    public void updateConfig(AppConfig appConfig) {
        log.info("Ready to update AppConfig");
        appConfig = configRepository.findByKey(appConfig.getKey()).toBuilder()
                .value(appConfig.getValue()).build();
        appConfig = configRepository.save(appConfig);
        log.info("Updated AppConfig: {}", appConfig);
    }
}
