package lt.vu.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Book.findAll", query = "select b from Book as b where b.library.id=:libraryId")
})
@Table(name = "book")
@Data
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Author")
    private String author;

    @ManyToOne
    @JoinColumn(name = "LibraryId")
    private Library library;

    @ManyToMany()
    @JoinTable(name = "rent_book")
    private List<Reader> readers = new ArrayList<>();

}
