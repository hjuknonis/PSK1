package lt.vu.persistence;

import lt.vu.entities.Reader;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ReaderDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Reader> loadAll() {
        return em.createNamedQuery("Reader.findAll", Reader.class).getResultList();
    }

    public void persist(Reader reader) {
        this.em.persist(reader);
    }

    public Reader findOne(Integer id) { return em.find(Reader.class, id); }

}
