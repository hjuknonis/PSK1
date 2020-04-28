package lt.vu.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Library.findAll", query = "select l from Library as l")
})
@Table(name = "library")
@Data
public class Library implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @OneToMany(mappedBy = "library")
    private List<Book> books = new ArrayList<>();
}
