package com.zhaojm.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.CaseDTO;
import com.zhaojm.bean.CaseInfoDTO;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.bean.PatientDTO;
import com.zhaojm.bean.UseraccountDTO;
import com.zhaojm.service.ICaseMedicineDetailService;
import com.zhaojm.service.ICaseService;
import com.zhaojm.service.IPatientService;
import com.zhaojm.service.IUseraccountService;
import com.zhaojm.util.ResultDTO;

@RestController
@RequestMapping
public class CaseController {
    
    @Autowired
    ICaseService caseService;
    
    @Autowired
    IPatientService patientService;
    
    @Autowired
    IUseraccountService  useraccountService;
     
    @Autowired
    ICaseMedicineDetailService caseMedicineDetailService;
    
    //case/saveCase 填写处方单
    @RequestMapping(value = "/case/saveCase",method=RequestMethod.POST)
    public ResultDTO<Integer> saveCase(@RequestBody CaseInfoDTO caseInfo,HttpSession session){
        
        UseraccountDTO loginUser =(UseraccountDTO) session.getAttribute("loginUser");
        
        PatientDTO patient = new PatientDTO();
        patient.setPatientName(caseInfo.getPatientName());
        if(useraccountService.queryPatientName(patient).size() < 1) {
            patient.setPatientSex(caseInfo.getPatientSex().equals("男") ? "M":"F");
            patient.setPatientBorn(caseInfo.getPatientAge());
            patientService.creatPatient(patient);
        }
        CaseDTO caseInset = new CaseDTO();
        caseInset.setIllnessDesc(caseInfo.getIllnessDesc());
        caseInset.setPatientName(caseInfo.getPatientName());
        caseInset.setDoctorName(caseInfo.getDoctorName());
        caseInset.setIllnessTime(caseInfo.getIllnessTime());
        caseInset.setCureCycle(caseInfo.getCureCycle());
        //加入session 中的登陆用户的
        caseInset.setEnterPerson(String.valueOf(loginUser.getDoctor().getDoctorId()));
        caseService.creatCase(caseInset);
        int caseId = caseInset.getCaseId();
        
        int detail = caseMedicineDetailService.creatCaseDeatil(caseId,caseInfo.getDetailList());
        if(caseId > 0 && detail >0 ) 
            return ResultDTO.valueOfSuccess();
        else
            return ResultDTO.valueOfError("新建处方单时出现错误");
    }
    
    //查询处方单 得到登陆用户的所创建的 处方单
    @RequestMapping(value="/case/getCaseList",method=RequestMethod.POST)
    public ResultDTO<PageInfo<CaseDTO>> getCaseByDoctor(@RequestBody PageRequestDTO<CaseDTO> caseinfo,HttpSession session){
        //得到登陆用户
        UseraccountDTO loginUser = (UseraccountDTO) session.getAttribute("logUser");
        String doctorId = String.valueOf(loginUser.getDoctor().getDoctorId());
        caseinfo.getParam().setEnterPerson(doctorId);
        
        
        return ResultDTO.valueOfSuccess(caseService.getCaseList(caseinfo));
    }
    
    //根据 casdid 查出改信息的所有内容
    @RequestMapping(value="/case/getCaseAll/{caseId}",method=RequestMethod.GET)
    public ResultDTO<CaseDTO> getCaseAll(@PathVariable Integer caseId){
        
        return ResultDTO.valueOfSuccess(caseService.getCase(caseId));
        
    }
    

}
