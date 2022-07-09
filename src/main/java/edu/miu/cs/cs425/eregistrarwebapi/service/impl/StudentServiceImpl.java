package edu.miu.cs.cs425.eregistrarwebapi.service.impl;

import edu.miu.cs.cs425.eregistrarwebapi.dto.StudentRequest;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getAllStudents() {
        var students = this.studentRepository.findAll(Sort.by("lastName"));
        return students;
    }

    @Override
    public Student registerStudent(StudentRequest studentRequest) {
        var student = Student.build(null, studentRequest.getStudentNumber(), studentRequest.getFirstName(), studentRequest.getMiddleName(),
                studentRequest.getLastName(), studentRequest.getCgpa(),studentRequest.getDateOfEnrollment(), studentRequest.getIsInternational());
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        var student = this.studentRepository.findById(studentId);
        return student.orElse(null);
    }

    @Override
    public Student updateStudentById(StudentRequest studentRequest, Integer studentId) {
        var student = Student.build(studentId, studentRequest.getStudentNumber(), studentRequest.getFirstName(), studentRequest.getMiddleName(),
                studentRequest.getLastName(), studentRequest.getCgpa(),studentRequest.getDateOfEnrollment(), studentRequest.getIsInternational());
        return studentRepository.save(student);

    }

    @Override
    public void removeStudentById(Integer studentId) {
        this.studentRepository.deleteById(studentId);
    }
}
