package edu.miu.cs.cs425.eregistrarwebapi.controller.restapi.v1;

import edu.miu.cs.cs425.eregistrarwebapi.dto.StudentRequest;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/eregistrar/api/v1/student")
public class StudentRestController {

    @Autowired
    public StudentService studentService;

    @GetMapping(value = {"/list", "/all"})
    public ResponseEntity<List<Student>> listStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping(value ={"/new"})
    public ResponseEntity<Student> addNewStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.registerStudent(studentRequest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PutMapping(value = "/update/{studentId}")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody StudentRequest studentRequest, @PathVariable Integer studentId) {
        return new ResponseEntity<>(studentService.updateStudentById(studentRequest, studentId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public ResponseEntity.BodyBuilder deleteStudent(@PathVariable Integer studentId) {
        studentService.removeStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK);
    }

}
