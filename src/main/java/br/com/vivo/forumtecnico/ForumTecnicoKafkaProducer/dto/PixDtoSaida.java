package br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.dto;

import br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.model.PixStatus;

import java.time.LocalDateTime;

public record PixDtoSaida(
        String identificador,
        String chaveOrigem,
        String chaveDestino,
        Double valor,
        LocalDateTime dataTransferencia,
        String status
) {
}
