package com.zhaojm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhaojm.bean.CaseDTO;
@Mapper
public interface ICaseMapper {
    int deleteByPrimaryKey(Integer caseId);

    int insert(CaseDTO record);

    int insertSelective(CaseDTO record);

    CaseDTO selectByPrimaryKey(Integer caseId);

    int updateByPrimaryKeySelective(CaseDTO record);

    int updateByPrimaryKey(CaseDTO record);
}