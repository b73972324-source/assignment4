package com.example.demo.service.impl;

import com.example.demo.model.dto.StudentDTO;
import com.example.demo.model.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){this.studentRepository = studentRepository;}
    @Override
    public StudentDTO create(StudentDTO dto){
        Student student = Student.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .age(dto.getAge())
                .build();
        student = studentRepository.save(student);
        return mapToDTO(student);
    }
    @Override
    public StudentDTO getById(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return mapToDTO(student);
    }
    @Override
    public List<StudentDTO> getAll(){
        return studentRepository.findAll()
        .stream()
        .map(this::mapToDTO)
        .collect(Collectors.toList());
    }
    @Override
    public StudentDTO update(Long id, StudentDTO dto){
        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());
        Student updated = studentRepository.save(student);
        return mapToDTO(updated);
    }
    @Override
    public void delete(Long id){
        studentRepository.deleteById(id);
    }
    public StudentDTO mapToDTO(Student student){
        return StudentDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .age(student.getAge())
                .build();
    }
}
