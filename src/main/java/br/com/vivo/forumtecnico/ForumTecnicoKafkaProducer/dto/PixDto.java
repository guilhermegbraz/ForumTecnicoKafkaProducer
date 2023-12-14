package br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.dto;

import br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.model.Pix;
import br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.model.PixStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record PixDto(

        String chaveOrigem,
        String chaveDestino,
        Double valor

) {
    public Pix toPix() {
        Pix pix =  new Pix();
        pix.setValor(this.valor);
        pix.setChaveOrigem(this.chaveOrigem);
        pix.setChaveDestino(this.chaveDestino);


        return pix;
    }
}
