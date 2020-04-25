package com.ayaxsoft.studentapp.controller;

import com.ayaxsoft.studentapp.domain.Teacher;
import com.ayaxsoft.studentapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/teacher")
public class TeacherController extends ResourceController<Teacher> {
    @Autowired
    private TeacherService teacherService;

    @Override
    ResponseEntity<List<Teacher>> index() {
        List<Teacher> teachers = this.teacherService.getAll();
        if (teachers.size() == 0)
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Teacher>>(teachers, HttpStatus.OK);
    }

    @Override
    ResponseEntity<Teacher> save(Teacher entity) {
        Teacher teacher = this.teacherService.save(entity);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }

    @Override
    ResponseEntity<Teacher> update(Teacher entity) {
        Teacher teacher = this.teacherService.save(entity);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }

    @Override
    ResponseEntity<Teacher> details(int id) {
        Teacher teacher = this.teacherService.getById(id);
        if (teacher == null)
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }

    @Override
    ResponseEntity<String> delete(int id) {
        this.teacherService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
