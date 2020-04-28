package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Book;
import lt.vu.mybatis.model.Reader;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectAll(Integer libraryId);

}