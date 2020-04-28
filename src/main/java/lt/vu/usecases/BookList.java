package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Book;
import lt.vu.entities.Library;
import lt.vu.persistence.BookDAO;
import lt.vu.persistence.LibraryDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class BookList{

    @Inject
    private LibraryDAO libraryDAO;

    @Inject
    private BookDAO bookDAO;

    @Getter
    @Setter
    private Book book = new Book();

    @Getter
    @Setter
    private Library library = new Library();

    @Getter
    private List<Book> bookList;


    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer libraryId = Integer.parseInt(requestParameters.get("libraryId"));
        this.library = libraryDAO.findOne(libraryId);
        loadLibraryBooks(libraryId);
    }

    private void loadLibraryBooks(Integer libraryId) {
        this.bookList = bookDAO.loadAll(libraryId);
    }

    @Transactional
    public String createBook() {
        book.setLibrary(this.library);
        bookDAO.persist(book);
        return "/books?faces-redirect=true&libraryId=" + this.library.getId();
    }
}