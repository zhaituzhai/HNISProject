package com.zhaojm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.MedicineDTO;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.mapper.IMedicineMapper;
import com.zhaojm.service.IMedicineService;

@Service
public class MedicineServiceImpl implements IMedicineService {
    
    @Autowired
    IMedicineMapper medicineMapper;

    @Override
    public int addMedicine(MedicineDTO medicine) {
        
        return medicineMapper.insertSelective(medicine);
        
    }

    @Override
    public int delMedicineByPrimkey(Integer medicineId) {
        
        return medicineMapper.deleteByPrimaryKey(medicineId);
    }

    @Override
    public int updateMedicine(MedicineDTO medicine) {
        
        return medicineMapper.updateByPrimaryKeySelective(medicine);
    }

    @Override
    public PageInfo<MedicineDTO> queryMedicineList(PageRequestDTO<MedicineDTO> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<MedicineDTO> list = medicineMapper.queryMedicineList(page.getParam());
        return new PageInfo<MedicineDTO>(list);
    }

    @Override
    public int verfiy(MedicineDTO medicine) {
        MedicineDTO trueMedicine = medicineMapper.selectByVerfiy(medicine);
        if(null != trueMedicine)
            return 1;
        else
            return 0;
    }

}
