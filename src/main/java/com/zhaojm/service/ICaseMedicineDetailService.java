package com.zhaojm.service;

import java.util.List;

import com.zhaojm.bean.CaseMedicineDetailDTO;

public interface ICaseMedicineDetailService {
    
    int creatCaseDeatil(int caseId,List<CaseMedicineDetailDTO> detailList);

}
