package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.Api.Api;
import com.example.exercisejparelationi.Model.Student;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Service.StudentService;
import com.example.exercisejparelationi.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudent()


    {
        return ResponseEntity.status(200).body(studentService.getAllStudent());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new Api("Student add"));
    }
    @PutMapping("Up")
    public ResponseEntity UpStudent(@PathVariable Integer id,@RequestBody @Valid Student student){
        studentService.updateStudent(id,student);
        return ResponseEntity.status(200).body(new Api("Update Student"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id ){

        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student delete");
    }
}
