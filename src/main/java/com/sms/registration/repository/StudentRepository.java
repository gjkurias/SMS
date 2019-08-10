package com.sms.registration.repository;

import org.springframework.data.repository.CrudRepository;

import com.sms.registration.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
