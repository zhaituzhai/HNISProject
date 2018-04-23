package com.zhaojm.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 
 */
public class DiseaseDetailDTO implements Serializable {
    @ApiModelProperty("疾病主键")
    private Integer diseaseId;

    @ApiModelProperty("所属科室")
    private String departmentId;

    @ApiModelProperty("所示类型")
    private String typeId;

    @ApiModelProperty("描述")
    private String deseaseDescription;

    @ApiModelProperty("病发表现")
    private String deseaseManifestation;

    @ApiModelProperty("治疗方法")
    private String therapeuticMethod;

    @ApiModelProperty("治疗标识（自我治疗、在线治疗、到院治疗）")
    private String therapeuticMark;

    @ApiModelProperty("录入时间")
    private String entryTime;

    @ApiModelProperty("录入人")
    private String entryPerson;

    private static final long serialVersionUID = 1L;

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
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

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
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
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
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
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
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
        sb.append(", departmentId=").append(departmentId);
        sb.append(", typeId=").append(typeId);
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