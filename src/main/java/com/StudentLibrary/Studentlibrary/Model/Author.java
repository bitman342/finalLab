package com.StudentLibrary.Studentlibrary.Model;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Data
public class Author extends User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    private int age;
    private String country;


    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Book> books_written;

    public Author(){}

    public Author(String name, String email, int age, String country) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.country = country;
    }

    public Author(int i, String johnDoe, String mail) {
    }

    @Override
    public Long getId() {
        return super.getId();  // Assuming the ID is stored and managed in the User class
    }

    public Author get() {
        return this;
    }
}
