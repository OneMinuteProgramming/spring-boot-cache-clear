package com.live.code.spring_boot_ehcache.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "app_config")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppConfig {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "config_key")
    private String key;
    @Column(name = "config_value")
    private String value;
}
