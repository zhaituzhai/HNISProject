package com.zhaojm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
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

}
