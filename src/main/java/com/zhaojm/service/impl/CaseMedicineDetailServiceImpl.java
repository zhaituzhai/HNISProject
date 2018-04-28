package com.zhaojm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhaojm.bean.CaseMedicineDetailDTO;
import com.zhaojm.mapper.ICaseMedicineDetailMapper;
import com.zhaojm.service.ICaseMedicineDetailService;

@Service
public class CaseMedicineDetailServiceImpl implements ICaseMedicineDetailService {

    ICaseMedicineDetailMapper caseMedicineDetailMapper;
    
    @Override
    public int creatCaseDeatil(List<CaseMedicineDetailDTO> detailList) {
        int detailNum = 0;
        for (CaseMedicineDetailDTO datail : detailList) {
            detailNum += caseMedicineDetailMapper.insertSelective(datail);
        }
        return detailNum;
    }
    
    

}
