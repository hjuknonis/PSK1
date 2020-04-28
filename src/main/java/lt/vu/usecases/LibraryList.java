package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Library;
import lt.vu.persistence.LibraryDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class LibraryList {

    @Inject
    private LibraryDAO libraryDAO;

    @Getter
    @Setter
    private Library library = new Library();

    @Getter
    private List<Library> libraryList;

    @PostConstruct
    public void init(){
        loadAllLibraries();
    }

    private void loadAllLibraries(){
        this.libraryList = libraryDAO.loadAll();
    }

    @Transactional
    public String createLibrary() {
        this.libraryDAO.persist(library);
        return "index?faces-redirect=true";
    }

}
