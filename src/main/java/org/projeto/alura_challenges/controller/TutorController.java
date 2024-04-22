package org.projeto.alura_challenges.controller;

import jakarta.validation.Valid;
import org.projeto.alura_challenges.dto.TutorDetailsDTO;
import org.projeto.alura_challenges.dto.TutorRegisterDTO;
import org.projeto.alura_challenges.dto.TutorUpdateDTO;
import org.projeto.alura_challenges.service.TutorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private final TutorService service;

    public TutorController(TutorService service){
        this.service = service;

    }

    @PostMapping
    @Transactional
    public ResponseEntity<TutorDetailsDTO> RegisteringTutor(@Valid @RequestBody TutorRegisterDTO tutorDTO, UriComponentsBuilder uriBuilder){
            var tutor = service.saveNewTutor(tutorDTO);
        URI uri = uriBuilder.path("tutores/{id}").buildAndExpand(tutor.id()).toUri();

        return ResponseEntity.created(uri).body(tutor);

    }
    @GetMapping("{id}")
    @Transactional
    public ResponseEntity<TutorDetailsDTO> getByIdTutor(@PathVariable Long id){
        return  ResponseEntity.ok().body(service.findTutorById(id));
    }
    @GetMapping
    @Transactional
    public ResponseEntity<Page<TutorDetailsDTO>> getAllTutor(Pageable pageable){
        Page<TutorDetailsDTO> page = service.listAllTutors(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<TutorDetailsDTO> updateTutor(Long id, TutorUpdateDTO tutorDto){
        var tutor = service.updateTutor(id,tutorDto);
        return ResponseEntity.ok(tutor);
    }
    @DeleteMapping("{id}")
    @Transactional
    public void deleteTutor(@PathVariable Long id){
        service.deleteTutor(id);
    }

}
