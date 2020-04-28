package lt.vu.persistence;

import lt.vu.entities.Library;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class LibraryDAO {
    @Inject
    private EntityManager em;

    public List<Library> loadAll() {
        return em.createNamedQuery("Library.findAll", Library.class).getResultList();
    }

    public void persist(Library library) {
        this.em.persist(library);
    }

    public Library findOne(Integer id) {
        return em.find(Library.class, id);
    }

}

