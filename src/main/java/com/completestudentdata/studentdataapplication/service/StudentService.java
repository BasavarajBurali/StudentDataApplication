package com.completestudentdata.studentdataapplication.service;

import com.completestudentdata.studentdataapplication.entity.StudentData;
import com.completestudentdata.studentdataapplication.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public StudentData saveStudent(StudentData student) {
        return studentRepo.save(student);
    }

    public List<StudentData> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<StudentData> getStudentById(Long id) {
        return studentRepo.findById(id);
    }



    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    public StudentData updateStudent(StudentData studentData){
        return studentRepo.save(studentData);
    }

}
