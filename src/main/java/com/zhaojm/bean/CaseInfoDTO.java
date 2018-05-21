package com.zhaojm.bean;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CaseInfoDTO {

    /*
     * var caseInfo = { "patientName" : "" + $("#patientName").val(), "patientSex" :
     * "" + $("#patientSex").val(), "patientAge" : "" + $("#patientAge").val(),
     * "illnessTime" : "" + $("#illnessTime").val(), "cureCycle" : "" +
     * $("#cureCycle").val(), "doctorName" : "" + $("#doctorName").val(), "value" :
     * list };
     */

    private Integer caseId;
    private String patientId;
    private String patientName;
    private String patientSex;
    private String patientAge;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date illnessTime;
    private String cureCycle;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date cureTime;
    private String doctorName;
    private String illnessDesc;
    private String illnessGrade;
    private List<CaseMedicineDetailDTO> detailList;
    
    public String getIllnessGrade() {
        return illnessGrade;
    }
    public void setIllnessGrade(String illnessGrade) {
        this.illnessGrade = illnessGrade;
    }
    public Date getCureTime() {
        return cureTime;
    }
    public void setCureTime(Date cureTime) {
        this.cureTime = cureTime;
    }
    public Integer getCaseId() {
        return caseId;
    }
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }
    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    public String getIllnessDesc() {
        return illnessDesc;
    }
    public void setIllnessDesc(String illnessDesc) {
        this.illnessDesc = illnessDesc;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public String getPatientSex() {
        return patientSex;
    }
    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }
    public String getPatientAge() {
        return patientAge;
    }
    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }
    public Date getIllnessTime() {
        return illnessTime;
    }
    public void setIllnessTime(Date illnessTime) {
        this.illnessTime = illnessTime;
    }
    public String getCureCycle() {
        return cureCycle;
    }
    public void setCureCycle(String cureCycle) {
        this.cureCycle = cureCycle;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public List<CaseMedicineDetailDTO> getDetailList() {
        return detailList;
    }
    public void setDetailList(List<CaseMedicineDetailDTO> detailList) {
        this.detailList = detailList;
    }
    

}
