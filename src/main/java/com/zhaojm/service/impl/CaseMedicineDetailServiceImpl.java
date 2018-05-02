package com.zhaojm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaojm.bean.CaseMedicineDetailDTO;
import com.zhaojm.mapper.ICaseMedicineDetailMapper;
import com.zhaojm.service.ICaseMedicineDetailService;

@Service
public class CaseMedicineDetailServiceImpl implements ICaseMedicineDetailService {

    @Autowired
    ICaseMedicineDetailMapper caseMedicineDetailMapper;
    
    @Override
    public int creatCaseDeatil(int caseId,List<CaseMedicineDetailDTO> detailList) {
        int detailNum = 0;
        if(detailList != null) {
            for (CaseMedicineDetailDTO datail : detailList) {
                datail.setCaseId(caseId);
                detailNum += caseMedicineDetailMapper.insertSelective(datail);
            }
        }
        return detailNum;
    }
    
    

}
