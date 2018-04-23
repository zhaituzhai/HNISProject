package com.zhaojm.mapper;

import com.zhaojm.bean.DiseaseDetailDTO;

public interface IDiseaseDetailMapper {
    int deleteByPrimaryKey(Integer diseaseId);

    int insert(DiseaseDetailDTO record);

    int insertSelective(DiseaseDetailDTO record);

    DiseaseDetailDTO selectByPrimaryKey(Integer diseaseId);

    int updateByPrimaryKeySelective(DiseaseDetailDTO record);

    int updateByPrimaryKey(DiseaseDetailDTO record);
}