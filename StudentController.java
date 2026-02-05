package com.example.demo.controller;

import com.example.demo.model.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto){
        return ResponseEntity.ok(studentService.create(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Long id, @RequestBody StudentDTO dto){
        return ResponseEntity.ok(studentService.update(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
