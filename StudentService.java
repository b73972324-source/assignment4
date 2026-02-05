package com.example.demo.service;

import com.example.demo.model.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO create(StudentDTO dto);
    StudentDTO getById(Long id);
    List<StudentDTO> getAll();
    StudentDTO update(Long id, StudentDTO dto);
    void delete(Long id);
}
