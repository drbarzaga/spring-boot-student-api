package com.ayaxsoft.studentapp.repository;

import com.ayaxsoft.studentapp.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {
}
