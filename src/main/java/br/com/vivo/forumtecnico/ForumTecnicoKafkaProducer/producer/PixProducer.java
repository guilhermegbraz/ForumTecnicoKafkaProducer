package br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.producer;

import br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.dto.PixDtoSaida;
import br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.model.Pix;
import br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.model.PixStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PixProducer {

    @Autowired
    private KafkaTemplate<String, PixDtoSaida> kafkaTemplate;

    public PixDtoSaida processarPix(Pix pix) {
        pix.setStatus(PixStatus.EM_PROCESSAMENTO);
        pix.setIdentifier(UUID.randomUUID().toString());
        pix.setDataTransferencia(LocalDateTime.now());


        this.kafkaTemplate.send("PIX_TOPICO", pix.getIdentifier(), pix.toDtoSaida());

        return pix.toDtoSaida();
    }
}
