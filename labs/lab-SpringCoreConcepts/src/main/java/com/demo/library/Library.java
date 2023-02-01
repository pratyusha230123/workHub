package com.demo.library;

//import javax.persistence.Entity;

//import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="LIBRARIES")
//@Column
public class Library {

    @Id
    @Column(name="ID")
    private int id;
    @Column(name="NAME")
    private String name;

    //PRIMARY KEY
    @OneToMany(mappedBy = "library")
    private List<Author>  authorArrayList = new ArrayList<>();
    public Library() {

    }
    public Library(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAuthor(Author author){
        authorArrayList.add(author);
    }
}
