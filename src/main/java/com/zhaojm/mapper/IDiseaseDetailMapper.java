package com.zhaojm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhaojm.bean.DiseaseDetailDTO;

@Mapper
public interface IDiseaseDetailMapper {
    int deleteByPrimaryKey(Integer diseaseId);

    int insert(DiseaseDetailDTO record);

    int insertSelective(DiseaseDetailDTO record);

    DiseaseDetailDTO selectByPrimaryKey(Integer diseaseId);

    int updateByPrimaryKeySelective(DiseaseDetailDTO record);

    int updateByPrimaryKey(DiseaseDetailDTO record);
    
    List<DiseaseDetailDTO> queryDiseaseList(DiseaseDetailDTO record);
    
    //@Param("department")String department @Param("type") String type
    List<String> getDiseaseDepartment();
    
    List<String> getDiseaseType();
}