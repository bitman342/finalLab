package com.StudentLibrary.Studentlibrary.Services;

import com.StudentLibrary.Studentlibrary.Model.Card;
import com.StudentLibrary.Studentlibrary.Model.Student;
import com.StudentLibrary.Studentlibrary.Repositories.CardRepository;
import com.StudentLibrary.Studentlibrary.Repositories.StudentRepository;
import com.StudentLibrary.Studentlibrary.Services.utill.JWTUtil;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class StudentService {

    Logger logger= LoggerFactory.getLogger(StudentService.class);


    @Autowired
    StudentRepository studentRepository ;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardService cardService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JWTUtil jwtUtil;

//    public  List<Student> getAllStudents() {
//
//        StudentRepository.findAll();






    public String RegisterStudent(Student student){

        System.out.println("Student details"+student.getEmail());
        Student students = new Student();
        students.setAge(student.getAge());
        students.setCountry(student.getCountry());
        students.setEmail(student.getEmail());
        students.setName(student.getName());
        students.setPassword(passwordEncoder.encode(student.getPassword()));
        students.setCreatedOn(students.getCreatedOn());
        students.setUpdatedOn(students.getUpdatedOn());
        students.setRole(student.getRole());
         studentRepository.save(students);


         return jwtUtil.generateAccessToken(students);
    }

    public void createStudent (Student student){

        Card card=cardService.createCard(student);
        logger.info("The card for the student{} is created with the card details{}",student,card);


    }
    public int  updateStudent(Student student){
        return studentRepository.updateStudentDetails(student);


    }


    public void deleteStudent(int id ){

        cardService.deactivate(id);
        studentRepository.deleteCustom(id);

    }
}
