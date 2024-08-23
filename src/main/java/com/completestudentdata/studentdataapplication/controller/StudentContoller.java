package com.completestudentdata.studentdataapplication.controller;

import com.completestudentdata.studentdataapplication.entity.StudentData;
import com.completestudentdata.studentdataapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentContoller {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudentdata")
    public StudentData createStudent(@RequestBody StudentData student) {
        return studentService.saveStudent(student);
    }


    @GetMapping
    public List<StudentData> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentData> getStudentById(@PathVariable Long id) {
        Optional<StudentData> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<StudentData> updateStudent(@RequestBody StudentData studentData){
        StudentData updatedStudent=studentService.saveStudent(studentData);
        return new ResponseEntity<>(updatedStudent, HttpStatus.ACCEPTED);
    }
}
