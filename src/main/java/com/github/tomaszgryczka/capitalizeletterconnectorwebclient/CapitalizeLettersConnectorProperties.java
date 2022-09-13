package com.github.tomaszgryczka.capitalizeletterconnectorwebclient;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
@ConfigurationProperties(prefix = "capitalize.letters.service")
public class CapitalizeLettersConnectorProperties {
    @NotBlank
    private String url;

    private int readTimeout = 1000;
    private int writeTimeout = 1000;
    private int connectionTimeout = 5000;
    private int responseTimeout = 4000;
}
