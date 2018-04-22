package com.zhaojm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.InformationDTO;

public interface IInformationService {
    
    /**
     * 增
     */
    int creatInformation(InformationDTO information);
    /**
     * 删
     */
    int delInformation(Integer infoId);
    /**
     * 改
     */
    InformationDTO updateInformation(InformationDTO information);
    /**
     * 查(分页查询->info message)
     */
    PageInfo<InformationDTO> getInfoList(InformationDTO information);
    /**
     * 查(根据 infoId 查 该条信息详情)
     */
    InformationDTO getInformation(Integer infoId);
    
}
