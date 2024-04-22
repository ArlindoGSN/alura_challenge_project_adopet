package org.projeto.alura_challenges.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TutorRegisterDTO(
                    @NotBlank(message = "Name cannot be blank")
                    @NotNull(message = "Name cannot be null")
                    String name,

                    @NotBlank(message = "Phone number cannot be blank")
                    @NotNull(message = "Phone number cannot be null")
                    String phone_number,

                    @NotBlank(message = "City cannot be blank")
                    @NotNull(message = "City cannot be null")
                    String city,

                    String about

) {

}
