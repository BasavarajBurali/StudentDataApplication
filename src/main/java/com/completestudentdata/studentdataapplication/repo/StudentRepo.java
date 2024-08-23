package com.completestudentdata.studentdataapplication.repo;

import com.completestudentdata.studentdataapplication.entity.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentData, Long> {
}
