package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.Api.ApiException;
import com.example.exercisejparelationi.Model.Address;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher)
    {
        teacherRepository.save(teacher);
    }


    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("id doens't exist!");

        }
        teacherRepository.delete(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null) {
            throw new ApiException("id doesn't exiset!");
        }
        t.setName(teacher.getName());
        t.setEmail(teacher.getEmail());
        t.setAge(teacher.getAge());
        t.setSalary(teacher.getSalary());
        t.setAddress(teacher.getAddress());

        teacherRepository.save(t);
    }
    public Teacher getTeacher(Integer id){
        Teacher t=teacherRepository.findTeacherById(id);
        if (t==null){
            throw new ApiException("id not");
        }
        return t;
    }

}
