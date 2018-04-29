package com.zhaojm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.DiseaseDetailDTO;
import com.zhaojm.bean.PageRequestDTO;

public interface IDiseaseDetailService {
    
    /**
     * 增
     */
    int addDiseaseDetail (DiseaseDetailDTO disease);
    /**
     * 删
     */
    int delDiseaseDetailByPrimkey (Integer diseaseId);
    /**
     * 改
     */
    int updateDiseaseDetail(DiseaseDetailDTO disease);
    /**
     * 查
     */
    PageInfo<DiseaseDetailDTO> queryDiseaseDetailList(PageRequestDTO<DiseaseDetailDTO> disease);
    
    DiseaseDetailDTO queryDiseaseFull(Integer diseaseId);
    /**
     * 验证
     */
    int verfiy(DiseaseDetailDTO disease);
    
    List<String> queryDeptList ();
    
    List<String> queryTypeList ();

}
