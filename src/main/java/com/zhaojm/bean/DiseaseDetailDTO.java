package com.zhaojm.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 
 */
public class DiseaseDetailDTO implements Serializable {
    @ApiModelProperty("疾病主键")
    private Integer diseaseId;

    @ApiModelProperty("所属科室")
    private String department;

    @ApiModelProperty("所示类型")
    private String diseaseType;

    @ApiModelProperty("疾病名称")
    private String diseaseName;

    @ApiModelProperty("描述")
    private String deseaseDescription;

    @ApiModelProperty("病发表现")
    private String deseaseManifestation;

    @ApiModelProperty("治疗方法")
    private String therapeuticMethod;

    @ApiModelProperty("治疗标识（自我治疗、在线治疗、到院治疗）")
    private String therapeuticMark;

    @ApiModelProperty("录入时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date entryTime;

    @ApiModelProperty("录入人")
    private String entryPerson;

    private static final long serialVersionUID = 1L;

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDeseaseDescription() {
        return deseaseDescription;
    }

    public void setDeseaseDescription(String deseaseDescription) {
        this.deseaseDescription = deseaseDescription;
    }

    public String getDeseaseManifestation() {
        return deseaseManifestation;
    }

    public void setDeseaseManifestation(String deseaseManifestation) {
        this.deseaseManifestation = deseaseManifestation;
    }

    public String getTherapeuticMethod() {
        return therapeuticMethod;
    }

    public void setTherapeuticMethod(String therapeuticMethod) {
        this.therapeuticMethod = therapeuticMethod;
    }

    public String getTherapeuticMark() {
        return therapeuticMark;
    }

    public void setTherapeuticMark(String therapeuticMark) {
        this.therapeuticMark = therapeuticMark;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getEntryPerson() {
        return entryPerson;
    }

    public void setEntryPerson(String entryPerson) {
        this.entryPerson = entryPerson;
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
        DiseaseDetailDTO other = (DiseaseDetailDTO) that;
        return (this.getDiseaseId() == null ? other.getDiseaseId() == null : this.getDiseaseId().equals(other.getDiseaseId()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getDiseaseType() == null ? other.getDiseaseType() == null : this.getDiseaseType().equals(other.getDiseaseType()))
            && (this.getDiseaseName() == null ? other.getDiseaseName() == null : this.getDiseaseName().equals(other.getDiseaseName()))
            && (this.getDeseaseDescription() == null ? other.getDeseaseDescription() == null : this.getDeseaseDescription().equals(other.getDeseaseDescription()))
            && (this.getDeseaseManifestation() == null ? other.getDeseaseManifestation() == null : this.getDeseaseManifestation().equals(other.getDeseaseManifestation()))
            && (this.getTherapeuticMethod() == null ? other.getTherapeuticMethod() == null : this.getTherapeuticMethod().equals(other.getTherapeuticMethod()))
            && (this.getTherapeuticMark() == null ? other.getTherapeuticMark() == null : this.getTherapeuticMark().equals(other.getTherapeuticMark()))
            && (this.getEntryTime() == null ? other.getEntryTime() == null : this.getEntryTime().equals(other.getEntryTime()))
            && (this.getEntryPerson() == null ? other.getEntryPerson() == null : this.getEntryPerson().equals(other.getEntryPerson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDiseaseId() == null) ? 0 : getDiseaseId().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getDiseaseType() == null) ? 0 : getDiseaseType().hashCode());
        result = prime * result + ((getDiseaseName() == null) ? 0 : getDiseaseName().hashCode());
        result = prime * result + ((getDeseaseDescription() == null) ? 0 : getDeseaseDescription().hashCode());
        result = prime * result + ((getDeseaseManifestation() == null) ? 0 : getDeseaseManifestation().hashCode());
        result = prime * result + ((getTherapeuticMethod() == null) ? 0 : getTherapeuticMethod().hashCode());
        result = prime * result + ((getTherapeuticMark() == null) ? 0 : getTherapeuticMark().hashCode());
        result = prime * result + ((getEntryTime() == null) ? 0 : getEntryTime().hashCode());
        result = prime * result + ((getEntryPerson() == null) ? 0 : getEntryPerson().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", diseaseId=").append(diseaseId);
        sb.append(", department=").append(department);
        sb.append(", diseaseType=").append(diseaseType);
        sb.append(", diseaseName=").append(diseaseName);
        sb.append(", deseaseDescription=").append(deseaseDescription);
        sb.append(", deseaseManifestation=").append(deseaseManifestation);
        sb.append(", therapeuticMethod=").append(therapeuticMethod);
        sb.append(", therapeuticMark=").append(therapeuticMark);
        sb.append(", entryTime=").append(entryTime);
        sb.append(", entryPerson=").append(entryPerson);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}