package com.zhaojm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.DiseaseDetailDTO;
import com.zhaojm.bean.MedicineDTO;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.service.IMedicineService;
import com.zhaojm.util.ResultDTO;

@RestController
@RequestMapping
public class MedicineController {
    
    @Autowired
    IMedicineService medicineService;
    
    @RequestMapping(value="/medi/getMediList",method=RequestMethod.POST)
    public ResultDTO<PageInfo<MedicineDTO>> getMedicineList (@RequestBody PageRequestDTO<MedicineDTO> page){
        
        return ResultDTO.valueOfSuccess(medicineService.queryMedicineList(page));
        
    }
    
    @RequestMapping(value="/medi/getMedicine/{medicineId}",method=RequestMethod.POST)
    public ResultDTO<MedicineDTO> getUser(@PathVariable("medicineId") Integer medicineId){
        MedicineDTO medicineInfo = medicineService.queryMeidcineFull(medicineId);
        if(null != medicineInfo) {
            return ResultDTO.valueOfSuccess(medicineInfo);
        }else {
            return ResultDTO.valueOfError("无法查看此条信息");
        }
    }
    
    @RequestMapping(value = "/medi/creatMedicine", method = RequestMethod.POST)
    public ResultDTO<Integer> creatMedicine(@RequestBody MedicineDTO medicine){
        
        Integer isSave = medicineService.addMedicine(medicine);
        if(isSave > 0)
            return ResultDTO.valueOfSuccess();
        else
            return ResultDTO.valueOfError("添加失败！！");
    }
    
    @RequestMapping(value = "/medi/updateMedicine", method = RequestMethod.POST)
    public ResultDTO<Integer> updataMedicine(@RequestBody MedicineDTO medicine){
        
        Integer isUpdata = medicineService.updateMedicine(medicine);
        if(isUpdata > 0)
            return ResultDTO.valueOfSuccess();
        else
            return ResultDTO.valueOfError("更新失败！！");
    }

}
