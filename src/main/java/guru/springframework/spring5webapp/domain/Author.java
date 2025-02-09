package guru.springframework.spring5webapp.domain;

import sun.jvm.hotspot.gc.shared.Generation;

import javax.persistence.*;
import java.util.Set;
@Entity

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(name="author_book", joinColumns = @JoinColumn(name = "book_id")
            , inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Book> books;

    public Author() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Author(String firstName, String lastName, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }
}
