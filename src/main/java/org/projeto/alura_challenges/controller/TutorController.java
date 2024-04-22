package org.projeto.alura_challenges.controller;

import jakarta.validation.Valid;
import org.projeto.alura_challenges.dto.TutorDetailsDTO;
import org.projeto.alura_challenges.dto.TutorRegisterDTO;
import org.projeto.alura_challenges.service.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    private TutorService service;

    public TutorController(TutorService service){
        this.service = service;

    }

    @PostMapping
    public ResponseEntity<TutorDetailsDTO> RegisteringTutor(@Valid @RequestBody TutorRegisterDTO tutorDTO, UriComponentsBuilder uriBuilder){
            var tutor = service.saveNewTutor(tutorDTO);
        URI uri = uriBuilder.path("tutor/{id}").buildAndExpand(tutor.id()).toUri();

        return ResponseEntity.created(uri).body(tutor);

    }
}
