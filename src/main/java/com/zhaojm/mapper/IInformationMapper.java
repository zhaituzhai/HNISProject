package com.zhaojm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhaojm.bean.InformationDTO;

@Mapper
public interface IInformationMapper {
    int deleteByPrimaryKey(Integer informationId);

    int insert(InformationDTO record);

    int insertSelective(InformationDTO record);

    InformationDTO selectByPrimaryKey(Integer informationId);

    int updateByPrimaryKeySelective(InformationDTO record);

    int updateByPrimaryKey(InformationDTO record);
}