package com.live.code.spring_boot_ehcache.repository;

import com.live.code.spring_boot_ehcache.model.AppConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<AppConfig, Long> {
    AppConfig findByKey(String key);
}
