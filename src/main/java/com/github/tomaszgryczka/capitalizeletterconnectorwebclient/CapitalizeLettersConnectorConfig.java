package com.github.tomaszgryczka.capitalizeletterconnectorwebclient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.function.Consumer;

@Configuration
@ComponentScan
@RequiredArgsConstructor
@EnableConfigurationProperties(CapitalizeLettersConnectorProperties.class)
public class CapitalizeLettersConnectorConfig {

    private final CapitalizeLettersConnectorProperties properties;

    @Bean
    public WebClient createWebClient() {
        return WebClient.builder()
                .clientConnector(connector())
                .baseUrl(properties.getUrl())
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                })
                .build();
    }

    private ReactorClientHttpConnector connector() {
        final HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, properties.getConnectionTimeout())
                .responseTimeout(Duration.ofMillis(properties.getResponseTimeout()))
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(properties.getReadTimeout()));
                    connection.addHandlerLast(new WriteTimeoutHandler(properties.getWriteTimeout()));
                });
        return new ReactorClientHttpConnector(httpClient);
    }
}
