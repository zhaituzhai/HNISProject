package com.zhaojm.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 
 */
public class CaseDTO implements Serializable {
    @ApiModelProperty("病例主键")
    private Integer caseId;

    @ApiModelProperty("病人名字（未在数据库中）")
    private String patientName;

    @ApiModelProperty("主治医生")
    private String doctorName;

    @ApiModelProperty("病情描述")
    private String illnessDesc;

    @ApiModelProperty("患病时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date illnessTime;

    @ApiModelProperty("患病等级")
    private String illnessGrade;

    @ApiModelProperty("治疗时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cureTime;

    @ApiModelProperty("治疗周期")
    private String cureCycle;

    @ApiModelProperty("备注")
    private String remark;
    
    private List<CaseMedicineDetailDTO> caseDetail;

    private static final long serialVersionUID = 1L;

    public List<CaseMedicineDetailDTO> getCaseDetail() {
        return caseDetail;
    }

    public void setCaseDetail(List<CaseMedicineDetailDTO> caseDetail) {
        this.caseDetail = caseDetail;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getIllnessDesc() {
        return illnessDesc;
    }

    public void setIllnessDesc(String illnessDesc) {
        this.illnessDesc = illnessDesc;
    }

    public Date getIllnessTime() {
        return illnessTime;
    }

    public void setIllnessTime(Date illnessTime) {
        this.illnessTime = illnessTime;
    }

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

    public String getCureCycle() {
        return cureCycle;
    }

    public void setCureCycle(String cureCycle) {
        this.cureCycle = cureCycle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CaseDTO other = (CaseDTO) that;
        return (this.getCaseId() == null ? other.getCaseId() == null : this.getCaseId().equals(other.getCaseId()))
            && (this.getPatientName() == null ? other.getPatientName() == null : this.getPatientName().equals(other.getPatientName()))
            && (this.getDoctorName() == null ? other.getDoctorName() == null : this.getDoctorName().equals(other.getDoctorName()))
            && (this.getIllnessDesc() == null ? other.getIllnessDesc() == null : this.getIllnessDesc().equals(other.getIllnessDesc()))
            && (this.getIllnessTime() == null ? other.getIllnessTime() == null : this.getIllnessTime().equals(other.getIllnessTime()))
            && (this.getIllnessGrade() == null ? other.getIllnessGrade() == null : this.getIllnessGrade().equals(other.getIllnessGrade()))
            && (this.getCureTime() == null ? other.getCureTime() == null : this.getCureTime().equals(other.getCureTime()))
            && (this.getCureCycle() == null ? other.getCureCycle() == null : this.getCureCycle().equals(other.getCureCycle()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCaseId() == null) ? 0 : getCaseId().hashCode());
        result = prime * result + ((getPatientName() == null) ? 0 : getPatientName().hashCode());
        result = prime * result + ((getDoctorName() == null) ? 0 : getDoctorName().hashCode());
        result = prime * result + ((getIllnessDesc() == null) ? 0 : getIllnessDesc().hashCode());
        result = prime * result + ((getIllnessTime() == null) ? 0 : getIllnessTime().hashCode());
        result = prime * result + ((getIllnessGrade() == null) ? 0 : getIllnessGrade().hashCode());
        result = prime * result + ((getCureTime() == null) ? 0 : getCureTime().hashCode());
        result = prime * result + ((getCureCycle() == null) ? 0 : getCureCycle().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", caseId=").append(caseId);
        sb.append(", patientName=").append(patientName);
        sb.append(", doctorName=").append(doctorName);
        sb.append(", illnessDesc=").append(illnessDesc);
        sb.append(", illnessTime=").append(illnessTime);
        sb.append(", illnessGrade=").append(illnessGrade);
        sb.append(", cureTime=").append(cureTime);
        sb.append(", cureCycle=").append(cureCycle);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}