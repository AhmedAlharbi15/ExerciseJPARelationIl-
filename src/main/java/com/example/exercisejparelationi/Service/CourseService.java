package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.Api.ApiException;
import com.example.exercisejparelationi.Model.Course;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.CourseRepository;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    public List<Course> getAllCourses()
    {
        return courseRepository.findAll();
    }
    public void addCourse(Integer teacher_id, Course course){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if (teacher == null){
            throw new ApiException("id doesn't exiset!");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }
    public void UpCourse(Integer id, Course course){
        Course c = courseRepository.findCourseById(id);
        if (c==null){
            throw new ApiException("id doesn't exiset!");
        }
        c.setName(course.getName());
        courseRepository.save(c);
    }
    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course==null){
            throw new ApiException("id doesn't exiset!");
        }
        courseRepository.delete(course);
    }
    public String getCourseIDTeacherName(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        if (course==null){
            throw new ApiException("id doesn't exiset!");
        }
        Teacher teacher = course.getTeacher();
        if (teacher==null){
            throw new ApiException("There is no teacher");
        }
        return teacher.getName();
    }
}