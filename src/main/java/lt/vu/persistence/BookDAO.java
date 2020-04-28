package lt.vu.persistence;

import lt.vu.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class BookDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Book> loadAll(Integer libraryId) {
        return em.createNamedQuery("Book.findAll", Book.class).
                setParameter("libraryId", libraryId).getResultList();
    }

    public void persist(Book book) {
        this.em.persist(book);
    }

    public void remove(Book book) { this.em.remove(book); }

    public Book findOne(Integer id) { return em.find(Book.class, id); }

}
