package com.zhaojm.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.CaseDTO;
import com.zhaojm.bean.CaseInfoDTO;
import com.zhaojm.bean.CaseMedicineDetailDTO;
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
        
        BigDecimal medicinePrice = new BigDecimal(0);
        for (CaseMedicineDetailDTO detail : caseInfo.getDetailList()) {
            medicinePrice = medicinePrice.add(detail.getTotalPrice());
        }
        
        UseraccountDTO loginUser =(UseraccountDTO) session.getAttribute("logUser");
        
        //判断此人是否在数据库中（根据是否有patientID传值 如何存在就是数据库的老病人，如果没有就是新病人）
        //useraccountService.queryPatientName(patient).size() < 1
        PatientDTO patient = null;
        if(null == caseInfo.getPatientId() || caseInfo.getPatientId().equals("")) {
            patient = new PatientDTO();
            patient.setPatientName(caseInfo.getPatientName());
            patient.setPatientSex(caseInfo.getPatientSex().equals("男") ? "M":"F");
            patient.setPatientBorn(caseInfo.getPatientAge());
            patientService.creatPatient(patient);
        }
        CaseDTO caseInset = new CaseDTO();
        caseInset.setIllnessDesc(caseInfo.getIllnessDesc());
        if(null != patient) {
            caseInset.setPatientName( patient.getPatientId()+"-"+caseInfo.getPatientName());
        }else {
            caseInset.setPatientName( caseInfo.getPatientId()+"-"+caseInfo.getPatientName());
        }
        caseInset.setDoctorName(caseInfo.getDoctorName());
        caseInset.setIllnessTime(caseInfo.getIllnessTime());
        caseInset.setCureCycle(caseInfo.getCureCycle());
        caseInset.setCureTime(caseInfo.getCureTime());
        caseInset.setMedicineTotalPrice(medicinePrice);
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
    
    
    public void printChar(HttpServletResponse response,HttpServletRequest request ) {
        //response
//        request.get
        
        
    }
    
    
    //根据 casdid 查出改信息的所有内容
    @RequestMapping(value="/case/getCaseAll/{caseId}",method=RequestMethod.GET)
    public ResultDTO<CaseInfoDTO> getCaseAll(@PathVariable("caseId") Integer caseId){
        //case 
        CaseDTO caseInfo = caseService.getCase(caseId);
        //medicine
        List<CaseMedicineDetailDTO> detailList = caseMedicineDetailService.getListByCaseId(caseId);
        String patientName = caseInfo.getPatientName();
        String[] idName = patientName.split("-");
        //patient
        PatientDTO patient = patientService.getPatientById(Integer.parseInt(idName[0]));
        
        return ResultDTO.valueOfSuccess(fillCaseAll(caseInfo, patient, detailList));
        
    }
    
    private CaseInfoDTO fillCaseAll(CaseDTO caseInfo,PatientDTO patient,List<CaseMedicineDetailDTO> detailList) {
        CaseInfoDTO caseAll = new CaseInfoDTO();
        caseAll.setCaseId(caseInfo.getCaseId());
        caseAll.setCureCycle(caseInfo.getCureCycle());
        caseAll.setCureTime(caseInfo.getCureTime());
        caseAll.setDetailList(detailList);
        caseAll.setDoctorName(caseInfo.getDoctorName());
        caseAll.setIllnessDesc(caseInfo.getIllnessDesc());
        caseAll.setIllnessTime(caseInfo.getIllnessTime());
        caseAll.setPatientAge(patient.getPatientBorn());
        caseAll.setPatientId(""+patient.getPatientId());
        caseAll.setPatientName(patient.getPatientName());
        caseAll.setPatientSex(patient.getPatientSex());
        return caseAll;
    }
    

}
