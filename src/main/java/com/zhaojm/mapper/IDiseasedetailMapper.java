package com.zhaojm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhaojm.bean.DiseasedetailDTO;
@Mapper
public interface IDiseasedetailMapper {
    int deleteByPrimaryKey(Integer diseaseId);

    int insert(DiseasedetailDTO record);

    int insertSelective(DiseasedetailDTO record);

    DiseasedetailDTO selectByPrimaryKey(Integer diseaseId);

    int updateByPrimaryKeySelective(DiseasedetailDTO record);

    int updateByPrimaryKey(DiseasedetailDTO record);
}