package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.Api.ApiException;
import com.example.exercisejparelationi.DTO.AddressDTO;
import com.example.exercisejparelationi.Model.Address;
import com.example.exercisejparelationi.Model.Student;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudent()

    {
        return studentRepository.findAll();
    }

    public void addStudent(Student student)
    {
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        Student student = studentRepository.findStudentById(id);
        if (student == null) {
            throw new ApiException("id doens't exist!");

        }
        studentRepository.delete(student);
    }

    public void updateStudent(Integer id, Student student) {
        Student s = studentRepository.findStudentById(id);
        if (s == null) {
            throw new ApiException("id doesn't exiset!");
        }
        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setMajor(student.getMajor());

        studentRepository.save(s);
    }
}