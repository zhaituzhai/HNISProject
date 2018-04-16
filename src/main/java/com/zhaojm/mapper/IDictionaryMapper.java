package com.zhaojm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhaojm.bean.DictionaryDTO;
@Mapper
public interface IDictionaryMapper {
    int deleteByPrimaryKey(Integer dictionaryId);

    int insert(DictionaryDTO record);

    int insertSelective(DictionaryDTO record);

    DictionaryDTO selectByPrimaryKey(Integer dictionaryId);

    int updateByPrimaryKeySelective(DictionaryDTO record);

    int updateByPrimaryKey(DictionaryDTO record);
}