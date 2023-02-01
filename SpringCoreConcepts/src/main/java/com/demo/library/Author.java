package com.demo.library;

import javax.persistence.*;

@Entity
@Table(name="AUTHORS")
public class Author {
    @Id
    @Column(name="ID")
    private int id;

    @Column(name="NAME")
    private String name;

    //   FOREIGN KEY
    @ManyToOne
    @JoinColumn(name="LIBRARY_ID")
    private Library library;

    public Author() {
    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
