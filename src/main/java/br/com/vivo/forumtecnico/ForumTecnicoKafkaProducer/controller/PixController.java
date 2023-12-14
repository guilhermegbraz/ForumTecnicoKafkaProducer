package br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.controller;

import br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.dto.PixDto;
import br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.dto.PixDtoSaida;
import br.com.vivo.forumtecnico.ForumTecnicoKafkaProducer.producer.PixProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pix")
public class PixController {

    @Autowired
    private PixProducer producer;

    @PostMapping
    public ResponseEntity<PixDtoSaida> pagamentoPix(@RequestBody PixDto pixDto) {
        PixDtoSaida dtoSaida = this.producer.processarPix(pixDto.toPix());

        return ResponseEntity.ok(dtoSaida);
    }
}
