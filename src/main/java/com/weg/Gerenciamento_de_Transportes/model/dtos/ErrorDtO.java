package com.weg.Gerenciamento_de_Transportes.model.dtos;

import java.time.Instant;

public record ErrorDtO(String message, Instant instant) {
}
