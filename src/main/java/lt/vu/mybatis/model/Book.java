package lt.vu.mybatis.model;

import java.io.Serializable;
import lombok.Data;

/**
 * book
 * @author 
 */
@Data
public class Book implements Serializable {
    private Integer id;

    private String title;

    private String author;

    private Integer libraryid;

    private static final long serialVersionUID = 1L;
}