package com.github.tomaszgryczka.capitalizeletterconnectorwebclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public class CapitalizeLettersResponse {
    @JsonProperty(value = "INPUT")
    private String input;

    @JsonProperty(value = "OUTPUT")
    private String output;
}

