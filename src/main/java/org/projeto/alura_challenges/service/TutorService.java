package org.projeto.alura_challenges.service;

import org.projeto.alura_challenges.domain.tutor.Tutor;
import org.projeto.alura_challenges.dto.TutorDetailsDTO;
import org.projeto.alura_challenges.dto.TutorRegisterDTO;
import org.projeto.alura_challenges.dto.TutorUpdateDTO;
import org.projeto.alura_challenges.repository.TutorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    private final TutorRepository repository;

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

    public Page<TutorDetailsDTO> listAllTutors(Pageable pageable){
       Page<Tutor> findAll = repository.findAll(pageable);

      Page<TutorDetailsDTO> listTutor = findAll.map(TutorDetailsDTO::new);

        return listTutor;


    }
    public TutorDetailsDTO updateTutor(Long id,TutorUpdateDTO tutorDto){
        var tutor = repository.findById(id).orElseThrow(() -> new RuntimeException("Erro in location id"));

        tutor.updateTutor(tutorDto);
        var tutorUp = repository.save(tutor);
        return new TutorDetailsDTO(tutorUp);
    }
    public void deleteTutor(Long id){
        repository.deleteById(id);
    }
}
