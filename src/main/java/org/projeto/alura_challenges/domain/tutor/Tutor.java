package org.projeto.alura_challenges.domain.tutor;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.projeto.alura_challenges.dto.TutorRegisterDTO;
import org.projeto.alura_challenges.dto.TutorUpdateDTO;

import java.util.Objects;

@Table(name = "tutor")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone_number;

    private String city;

    private String about;

    public Tutor(TutorRegisterDTO tutordto){
        this.name = tutordto.name();
        this.phone_number = tutordto.phone_number();
        this.city = tutordto.city();
        this.about = tutordto.about();
    }
    public void updateTutor(TutorUpdateDTO tutorDto){
        if (tutorDto.name() != null){
            this.name = tutorDto.name();
        }
        if (tutorDto.phone_number() != null){
            this.phone_number = tutorDto.phone_number();
        }
        if (tutorDto.city() != null){
            this.city = tutorDto.city();
        }
        if (tutorDto.about() != null){
            this.about = tutorDto.about();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tutor tutor = (Tutor) o;
        return Objects.equals(id, tutor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
