package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.Api.Api;
import com.example.exercisejparelationi.Model.Course;
import com.example.exercisejparelationi.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses(){

        return ResponseEntity.ok().body(courseService.getAllCourses());
    }

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity addCourse(@PathVariable Integer teacher_id, @RequestBody @Valid Course course){

        courseService.addCourse(teacher_id, course);
        return ResponseEntity.ok().body(new Api("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody @Valid Course course){

        courseService.UpCourse(id, course);
        return ResponseEntity.ok().body(new Api("Update"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCoures(@PathVariable Integer id){

        courseService.deleteCourse(id);
        return ResponseEntity.ok().body(new Api("Delete"));
    }
    @GetMapping("/getcIDtName/{course_id}")
    public ResponseEntity getCourseIDTeacherName(@PathVariable Integer course_id){

        return ResponseEntity.ok().body(courseService.getCourseIDTeacherName(course_id));
    }
}
