package com.pj.springboot.rabbitmq.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private Integer edition;
    private Integer yearOfPublication;
    private String publisher;

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getIsbn(), getEdition(), getYearOfPublication(), getPublisher());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getId(), book.getId()) && Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getEdition(), book.getEdition()) &&
                Objects.equals(getYearOfPublication(), book.getYearOfPublication()) && Objects.equals(getPublisher(), book.getPublisher());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", edition=" + edition +
                ", yearOfPublication=" + yearOfPublication +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
