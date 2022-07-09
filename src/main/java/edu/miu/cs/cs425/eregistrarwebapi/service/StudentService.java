package edu.miu.cs.cs425.eregistrarwebapi.service;

import edu.miu.cs.cs425.eregistrarwebapi.dto.StudentRequest;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;

import java.util.List;

public interface StudentService {
//    http://localhost/eregistrar/api/student/list - Displays JSON array of Students data.
    List<Student> getAllStudents();
//    http://localhost/eregistrar/api/student/register - Register a new Student into the system
    Student registerStudent(StudentRequest studentRequest);
//    http://localhost/eregistrar/api/student/get/1 - Read/display a Student data for student with ID, 1.
    Student getStudentById(Integer studentId);
//    http://localhost/eregistrar/api/student/update/1 - Retrieves and Updates Student data for student with ID, 1.
    Student updateStudentById(StudentRequest studentRequest, Integer studentId);
//    http://localhost/eregistrar/api/student/delete/3 - Delete the student data for student with ID, 3.
    void removeStudentById(Integer studentId);
}
