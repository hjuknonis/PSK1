package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Reader;

import java.util.List;

public interface ReaderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reader record);

    int insertSelective(Reader record);

    Reader selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);

    List<Reader> selectAll();
}