package com.ayaxsoft.studentapp.controller;

import com.ayaxsoft.studentapp.domain.Student;
import com.ayaxsoft.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> index() {
        List<Student> students = studentService.getAll();
        if (students.size() == 0)
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.save(student), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> details(@PathVariable(name = "id") int id) {
        Student student = studentService.getById(id);
        if (student != null)
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.update(student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") int id){
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
