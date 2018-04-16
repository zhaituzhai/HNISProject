package com.zhaojm.bean;

import java.io.Serializable;

import org.springframework.boot.test.mock.mockito.MockBean;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 
 */
@MockBean
public class CaseDTO implements Serializable {
    @ApiModelProperty("病例主键")
    private Integer caseId;

    @ApiModelProperty("关联病人人（已在数据库）")
    private Integer patientId;

    @ApiModelProperty("病人名字（未在数据库中）")
    private String patientName;

    @ApiModelProperty("关联医生（写病例的人）")
    private Integer doctorId;

    @ApiModelProperty("疾病id")
    private Integer diseaseId;

    @ApiModelProperty("患病时间")
    private String illnessTime;

    @ApiModelProperty("患病等级")
    private String illnessGrade;

    @ApiModelProperty("治疗时间")
    private String cureTime;

    @ApiModelProperty("治疗周期")
    private String cureCycle;

    @ApiModelProperty("病情描述")
    private String illnessDesc;

    @ApiModelProperty("备注")
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getIllnessTime() {
        return illnessTime;
    }

    public void setIllnessTime(String illnessTime) {
        this.illnessTime = illnessTime;
    }

    public String getIllnessGrade() {
        return illnessGrade;
    }

    public void setIllnessGrade(String illnessGrade) {
        this.illnessGrade = illnessGrade;
    }

    public String getCureTime() {
        return cureTime;
    }

    public void setCureTime(String cureTime) {
        this.cureTime = cureTime;
    }

    public String getCureCycle() {
        return cureCycle;
    }

    public void setCureCycle(String cureCycle) {
        this.cureCycle = cureCycle;
    }

    public String getIllnessDesc() {
        return illnessDesc;
    }

    public void setIllnessDesc(String illnessDesc) {
        this.illnessDesc = illnessDesc;
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
            && (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
            && (this.getPatientName() == null ? other.getPatientName() == null : this.getPatientName().equals(other.getPatientName()))
            && (this.getDoctorId() == null ? other.getDoctorId() == null : this.getDoctorId().equals(other.getDoctorId()))
            && (this.getDiseaseId() == null ? other.getDiseaseId() == null : this.getDiseaseId().equals(other.getDiseaseId()))
            && (this.getIllnessTime() == null ? other.getIllnessTime() == null : this.getIllnessTime().equals(other.getIllnessTime()))
            && (this.getIllnessGrade() == null ? other.getIllnessGrade() == null : this.getIllnessGrade().equals(other.getIllnessGrade()))
            && (this.getCureTime() == null ? other.getCureTime() == null : this.getCureTime().equals(other.getCureTime()))
            && (this.getCureCycle() == null ? other.getCureCycle() == null : this.getCureCycle().equals(other.getCureCycle()))
            && (this.getIllnessDesc() == null ? other.getIllnessDesc() == null : this.getIllnessDesc().equals(other.getIllnessDesc()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCaseId() == null) ? 0 : getCaseId().hashCode());
        result = prime * result + ((getPatientId() == null) ? 0 : getPatientId().hashCode());
        result = prime * result + ((getPatientName() == null) ? 0 : getPatientName().hashCode());
        result = prime * result + ((getDoctorId() == null) ? 0 : getDoctorId().hashCode());
        result = prime * result + ((getDiseaseId() == null) ? 0 : getDiseaseId().hashCode());
        result = prime * result + ((getIllnessTime() == null) ? 0 : getIllnessTime().hashCode());
        result = prime * result + ((getIllnessGrade() == null) ? 0 : getIllnessGrade().hashCode());
        result = prime * result + ((getCureTime() == null) ? 0 : getCureTime().hashCode());
        result = prime * result + ((getCureCycle() == null) ? 0 : getCureCycle().hashCode());
        result = prime * result + ((getIllnessDesc() == null) ? 0 : getIllnessDesc().hashCode());
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
        sb.append(", patientId=").append(patientId);
        sb.append(", patientName=").append(patientName);
        sb.append(", doctorId=").append(doctorId);
        sb.append(", diseaseId=").append(diseaseId);
        sb.append(", illnessTime=").append(illnessTime);
        sb.append(", illnessGrade=").append(illnessGrade);
        sb.append(", cureTime=").append(cureTime);
        sb.append(", cureCycle=").append(cureCycle);
        sb.append(", illnessDesc=").append(illnessDesc);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}