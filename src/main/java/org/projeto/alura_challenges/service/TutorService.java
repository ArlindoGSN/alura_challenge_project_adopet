package org.projeto.alura_challenges.service;

import org.projeto.alura_challenges.domain.Tutor;
import org.projeto.alura_challenges.dto.TutorDetailsDTO;
import org.projeto.alura_challenges.dto.TutorRegisterDTO;
import org.projeto.alura_challenges.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    private TutorRepository repository;

    public TutorService(TutorRepository repository){
        this.repository = repository;
    }



    public TutorDetailsDTO saveNewTutor(TutorRegisterDTO tutorDto){
        var tutor = new Tutor(tutorDto);
        repository.save(tutor);

        return new TutorDetailsDTO(tutor);
    }

    public TutorDetailsDTO findTutorById(Long id) {

        var tutor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error in location tutor"));


        return new TutorDetailsDTO(tutor);
    }

    public List<TutorDetailsDTO> listAllTutors(){
        var listTutor = repository.findAll().stream().map((TutorDetailsDTO::new)).toList();

        return listTutor;


    }
}
