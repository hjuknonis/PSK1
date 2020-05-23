package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Book;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.BookDAO;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class EditBook implements Serializable {

    private Book book;

    @Inject
    private BookDAO bookDAO;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer bookId = Integer.parseInt(requestParameters.get("bookId"));

        this.book = bookDAO.findOne(bookId);
    }

    @Transactional
    @LoggedInvocation
    public String update(){
        try {
            bookDAO.update(this.book);
        } catch (OptimisticLockException e) {
            return "editBook?faces-redirect=true&bookId=" +
                    this.book.getId() +
                    "&error=optimistic-lock-exception";
        }

        return "index?faces-redirect=true";
    }

}
