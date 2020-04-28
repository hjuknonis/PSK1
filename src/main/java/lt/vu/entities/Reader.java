package lt.vu.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Reader.findAll", query = "select r from Reader as r")
})
@Table(name = "Reader")
@Data
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Firstname")
    private String firstname;

    @Column(name = "Lastname")
    private String lastname;

    @ManyToMany(mappedBy = "readers")
    private List<Book> books = new ArrayList<>();
}
