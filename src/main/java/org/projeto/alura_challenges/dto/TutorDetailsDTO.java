package org.projeto.alura_challenges.dto;

import org.projeto.alura_challenges.domain.Tutor;

public record TutorDetailsDTO(
        Long id,
        String name,
        String phone_number,
        String city,
        String about
) {
    public TutorDetailsDTO(Tutor tutor){
        this(tutor.getId(),
                tutor.getName(),
                tutor.getPhone_number(),
                tutor.getCity(),
                tutor.getAbout());
    }

}
