package com.example.exercisejparelationi.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;
    @NotEmpty(message = "Area should be not Empty")
    private String area;
    @NotEmpty(message = "Street should be not Empty")
    private String street;
    @NotNull(message = "Building Number should be not null")
    private Integer buildingNumber;

}
