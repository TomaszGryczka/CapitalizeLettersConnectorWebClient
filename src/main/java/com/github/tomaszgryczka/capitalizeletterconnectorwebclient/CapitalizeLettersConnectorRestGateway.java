package com.github.tomaszgryczka.capitalizeletterconnectorwebclient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class CapitalizeLettersConnectorRestGateway implements CapitalizeLetterConnectorGateway {

    private final WebClient webClient;

    // todo
    public CapitalizeLettersResponse capitalizeLetters(CapitalizeLettersRequest request) {
        return null;
    }
}
