package com.example.demo.entity.employee;

import com.example.demo.other.Pouya;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="employee")
public class Employee {

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(min = 3 , max = 20 , message = "Out Of Bound")
    @NotNull(message = "is not null")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "is not null")
    private String lastName;


    @Pouya()
    @Column(name = "email")
    private String email;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
