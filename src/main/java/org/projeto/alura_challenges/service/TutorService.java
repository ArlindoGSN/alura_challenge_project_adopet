package org.projeto.alura_challenges.service;

import org.projeto.alura_challenges.domain.Tutor;
import org.projeto.alura_challenges.dto.TutorDetailsDTO;
import org.projeto.alura_challenges.dto.TutorRegisterDTO;
import org.projeto.alura_challenges.repository.TutorRepository;
import org.springframework.stereotype.Service;

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

}
