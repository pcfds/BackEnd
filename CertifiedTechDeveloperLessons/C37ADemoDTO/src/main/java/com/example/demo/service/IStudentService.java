package com.example.demo.service;

import com.example.demo.model.StudentDTO;

import java.util.Collection;
import java.util.Set;

public interface IStudentService {

    void createStudent(StudentDTO stu);
    StudentDTO readStudent(Long id);
    void updateStudent(StudentDTO stu);
    void deleteStudent(Long id);

    Collection<StudentDTO> getAll();
    Set<StudentDTO> getStudentsWithLastnameLike(String lastname);


}
