package com.github.tomaszgryczka.capitalizeletterconnectorwebclient;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CapitalizeLettersRequest {
    String input;
}
