package org.projeto.alura_challenges.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import org.projeto.alura_challenges.dto.TutorRegisterDTO;

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
