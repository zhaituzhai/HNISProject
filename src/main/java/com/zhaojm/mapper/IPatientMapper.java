package com.zhaojm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhaojm.bean.PatientDTO;

@Mapper
public interface IPatientMapper {
    int deleteByPrimaryKey(Integer patientId);

    int insert(PatientDTO record);

    int insertSelective(PatientDTO record);

    PatientDTO selectByPrimaryKey(Integer patientId);

    int updateByPrimaryKeySelective(PatientDTO record);

    int updateByPrimaryKey(PatientDTO record);
    
    PatientDTO selectByUserId(Integer userId);
    
    List<PatientDTO> queryPatientList (PatientDTO patient);
}