package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }



    /*	@Bean public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return args -> {
			createStudent(studentDAO);
		//	findBy(3,studentDAO);
		//	getAll(studentDAO);
		};
	}*/

   /* private void getAll(StudentDAO studentDAO) {
        System.out.println("Get All students objects ...");
        List<Student> students = studentDAO.getAll();
        System.out.println(students);


    }

    private void findBy(int i, StudentDAO studentDAO) {

        Student student = studentDAO.find(i);
        System.out.println("finding the student ..." + i + " its ..." + student.toString());

    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.println("Creating new student object ...");
        Student temp = new Student("zero", "Doe", "paul@luv2code.com");

        System.out.println("saving the student ...");

        studentDAO.save(temp);
        System.out.println("saved student . generate id : " + temp.getId());
    }
*/

}
