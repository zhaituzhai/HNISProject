package com.zhaojm.mapper;

import com.zhaojm.bean.CaseDTO;

public interface ICaseMapper {
    int deleteByPrimaryKey(Integer caseId);

    int insert(CaseDTO record);

    int insertSelective(CaseDTO record);

    CaseDTO selectByPrimaryKey(Integer caseId);

    int updateByPrimaryKeySelective(CaseDTO record);

    int updateByPrimaryKey(CaseDTO record);
}