package com.zhaojm.mapper;

import java.util.List;

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

    List<CaseDTO> queryCaseList(CaseDTO record);

}