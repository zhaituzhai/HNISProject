package com.zhaojm.mapper;

import com.zhaojm.bean.MedicineDTO;

public interface IMedicineMapper {
    int deleteByPrimaryKey(Integer medicineId);

    int insert(MedicineDTO record);

    int insertSelective(MedicineDTO record);

    MedicineDTO selectByPrimaryKey(Integer medicineId);

    int updateByPrimaryKeySelective(MedicineDTO record);

    int updateByPrimaryKey(MedicineDTO record);
}