package com.example.exercisejparelationi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private Integer id;

    @NotEmpty(message = "Name should not be Empty")
    private String name;
    @NotNull(message = "Name should not be Null")
    private Integer age;
    @NotEmpty(message = "Name should not be Empty")
    private String major;

    @ManyToMany
    @JsonIgnore
    private Set<Course>courses;
}
