package com.Lab08.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private boolean isActive;

//    Tạo mối quan hệ với bảng Author
    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "mainAuthorId")
    private Author mainAuthor;

    @ManyToMany
    @JoinTable(
            name = "Book_Author",
            joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "authorId")
    )
    private List<Author> coAuthors = new ArrayList<>();
}
