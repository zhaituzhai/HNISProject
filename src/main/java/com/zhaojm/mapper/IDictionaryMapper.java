package com.zhaojm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhaojm.bean.DictionaryDTO;
@Mapper
public interface IDictionaryMapper {
    int deleteByPrimaryKey(Integer dictionaryId);

    int insert(DictionaryDTO record);

    int insertSelective(DictionaryDTO record);

    DictionaryDTO selectByPrimaryKey(Integer dictionaryId);

    int updateByPrimaryKeySelective(DictionaryDTO record);

    int updateByPrimaryKey(DictionaryDTO record);
    
    List<DictionaryDTO> getDictionaryByType(@Param("dataType") String dataType);
}