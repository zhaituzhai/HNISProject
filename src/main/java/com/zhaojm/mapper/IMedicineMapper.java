package com.zhaojm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhaojm.bean.MedicineDTO;

@Mapper
public interface IMedicineMapper {
    int deleteByPrimaryKey(Integer medicineId);

    int insert(MedicineDTO record);

    int insertSelective(MedicineDTO record);

    MedicineDTO selectByPrimaryKey(Integer medicineId);
    
//    MedicineDTO selectByName(MedicineDTO medicine);

    int updateByPrimaryKeySelective(MedicineDTO record);

    int updateByPrimaryKey(MedicineDTO record);
    
    List<MedicineDTO> queryMedicineList(MedicineDTO medicine);

    MedicineDTO selectByVerfiy(MedicineDTO medicine);
}