package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.Api.Api;
import com.example.exercisejparelationi.Model.Address;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeacher()

    {
        return ResponseEntity.status(200).body(teacherService.getAllTeacher());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new Api("Teacher add"));
    }
    @PutMapping("Up")
    public ResponseEntity UpTeacher(@PathVariable Integer id,@RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(new Api("Update Teacher"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id ){

        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher delete");
    }
    @GetMapping("/getT/{id}")
    public ResponseEntity getT(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacher(id));


    }
}
