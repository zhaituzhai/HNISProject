package com.zhaojm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 查看病例库的分页信息
     * @param page
     * @return
     */
    @RequestMapping(value = "/dise/getDiseList", method = RequestMethod.POST)
    public ResultDTO<PageInfo<DiseaseDetailDTO>> getMedicineList(@RequestBody PageRequestDTO<DiseaseDetailDTO> page) {

        return ResultDTO.valueOfSuccess(diseaseDetailService.queryDiseaseDetailList(page));

    }
    
    /**
     * 得到科室的信息
     * @return
     */
    @RequestMapping(value = "/dise/getDeptList", method = RequestMethod.POST)
    public ResultDTO<List<String>> getDeptList() {

        return ResultDTO.valueOfSuccess(diseaseDetailService.queryDeptList());

    }
    /**
     * 得到疾病类型的信息
     * @return
     */
    @RequestMapping(value = "/dise/getTypeList", method = RequestMethod.POST)
    public ResultDTO<List<String>> getTypeList() {

        return ResultDTO.valueOfSuccess(diseaseDetailService.queryTypeList());

    }
    
    @RequestMapping(value="/dise/getDisease/{diseaseId}",method=RequestMethod.POST)
    public ResultDTO<DiseaseDetailDTO> getUser(@PathVariable("diseaseId") Integer diseaseId){
        DiseaseDetailDTO diseaseInfo = diseaseDetailService.queryDiseaseFull(diseaseId);
        if(null != diseaseInfo) {
            return ResultDTO.valueOfSuccess(diseaseInfo);
        }else {
            return ResultDTO.valueOfError("无法查看磁条信息");
        }
    }
    
    @RequestMapping(value = "/dise/creatDisease", method = RequestMethod.POST)
    public ResultDTO<Integer> creatDisease(@RequestBody DiseaseDetailDTO disease){
        
        Integer isSave = diseaseDetailService.addDiseaseDetail(disease);
        if(isSave > 0)
            return ResultDTO.valueOfSuccess();
        else
            return ResultDTO.valueOfError("添加失败！！");
    }
    
    @RequestMapping(value = "/dise/updateDisease", method = RequestMethod.POST)
    public ResultDTO<Integer> updataDisease(@RequestBody DiseaseDetailDTO disease){
        
        Integer isUpdata = diseaseDetailService.updateDiseaseDetail(disease);
        if(isUpdata > 0)
            return ResultDTO.valueOfSuccess();
        else
            return ResultDTO.valueOfError("更新失败！！");
    }

}
