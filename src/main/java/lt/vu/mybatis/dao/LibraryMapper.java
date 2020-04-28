package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Library;
import org.mybatis.cdi.Mapper;

@Mapper
public interface LibraryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Library record);

    int insertSelective(Library record);

    Library selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Library record);

    int updateByPrimaryKey(Library record);
}