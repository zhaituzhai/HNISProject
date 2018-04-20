package com.zhaojm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhaojm.bean.DoctorDTO;

@Mapper
public interface IDoctorMapper {
    int deleteByPrimaryKey(Integer doctorId);

    int insert(DoctorDTO record);

    int insertSelective(DoctorDTO record);

    DoctorDTO selectByPrimaryKey(Integer doctorId);

    int updateByPrimaryKeySelective(DoctorDTO record);

    int updateByPrimaryKey(DoctorDTO record);
    
    DoctorDTO selectByUserId(Integer userId);
    
    List<DoctorDTO> queryDoctorList(DoctorDTO doctor);
}