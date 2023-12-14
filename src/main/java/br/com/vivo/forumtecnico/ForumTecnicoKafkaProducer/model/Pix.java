package br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.model;

import br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.dto.PixDtoSaida;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pix {

    private String identifier;
    private String chaveOrigem;
    private String chaveDestino;
    private Double valor;
    private LocalDateTime dataTransferencia;
    private PixStatus status;

    public PixDtoSaida toDtoSaida() {
        return new PixDtoSaida(this.getIdentifier(), this.getChaveOrigem(), this.getChaveDestino(), this.getValor(),
                this.getDataTransferencia(), this.getStatus().toString());
    }
}
