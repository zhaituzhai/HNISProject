package com.zhaojm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.DiseaseDetailDTO;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.service.IDiseaseDetailService;
import com.zhaojm.util.ResultDTO;

@RestController
@RequestMapping
public class DiseaseDetailController {

    @Autowired
    IDiseaseDetailService diseaseDetailService;

    @RequestMapping(value = "/dise/getDiseList", method = RequestMethod.POST)
    public ResultDTO<PageInfo<DiseaseDetailDTO>> getMedicineList(@RequestBody PageRequestDTO<DiseaseDetailDTO> page) {

        return ResultDTO.valueOfSuccess(diseaseDetailService.queryDiseaseDetailList(page));

    }
    
    @RequestMapping(value = "/dise/getDeptList", method = RequestMethod.POST)
    public ResultDTO<List<String>> getDeptList() {

        return ResultDTO.valueOfSuccess(diseaseDetailService.queryDeptList());

    }
    @RequestMapping(value = "/dise/getTypeList", method = RequestMethod.POST)
    public ResultDTO<List<String>> getTypeList() {

        return ResultDTO.valueOfSuccess(diseaseDetailService.queryTypeList());

    }

}
