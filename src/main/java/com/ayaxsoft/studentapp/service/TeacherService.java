package com.ayaxsoft.studentapp.service;

import com.ayaxsoft.studentapp.domain.Teacher;
import com.ayaxsoft.studentapp.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService extends BaseService<Teacher> {

    @Autowired
    private ITeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher save(Teacher entity) {
        return teacherRepository.save(entity);
    }

    @Override
    public Teacher update(Teacher entity) {
        return teacherRepository.save(entity);
    }

    @Override
    public Teacher getById(int id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        teacherRepository.deleteById(id);
    }
}
