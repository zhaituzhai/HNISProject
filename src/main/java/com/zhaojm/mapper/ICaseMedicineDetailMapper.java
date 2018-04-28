package com.zhaojm.mapper;

import java.util.List;

import com.zhaojm.bean.CaseMedicineDetailDTO;

public interface ICaseMedicineDetailMapper {
    int deleteByPrimaryKey(Integer caseMedicineId);

    int insert(CaseMedicineDetailDTO record);

    int insertSelective(CaseMedicineDetailDTO record);

    CaseMedicineDetailDTO selectByPrimaryKey(Integer caseMedicineId);

    int updateByPrimaryKeySelective(CaseMedicineDetailDTO record);

    int updateByPrimaryKey(CaseMedicineDetailDTO record);
    
    List<CaseMedicineDetailDTO> queryDetailList(Integer CaseId);
}