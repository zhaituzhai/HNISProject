package com.zhaojm.bean;

import java.io.Serializable;

import org.springframework.boot.test.mock.mockito.MockBean;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 
 */
@MockBean
public class PatientDTO implements Serializable {
    @ApiModelProperty("病人主键")
    private Integer patientId;

    @ApiModelProperty("关联用户id")
    private Integer userId;

    @ApiModelProperty("病人名字")
    private String patientName;

    @ApiModelProperty("病人性别")
    private String patientSex;

    @ApiModelProperty("病人生日")
    private String patientBorn;

    @ApiModelProperty("病人民族")
    private String patientNation;

    @ApiModelProperty("血型")
    private String bloodtype;

    @ApiModelProperty("职业")
    private String patientOccupation;

    @ApiModelProperty("婚否")
    private String patientMarriage;

    @ApiModelProperty("病人图片")
    private String patientIcon;

    private static final long serialVersionUID = 1L;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getPatientBorn() {
        return patientBorn;
    }

    public void setPatientBorn(String patientBorn) {
        this.patientBorn = patientBorn;
    }

    public String getPatientNation() {
        return patientNation;
    }

    public void setPatientNation(String patientNation) {
        this.patientNation = patientNation;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getPatientOccupation() {
        return patientOccupation;
    }

    public void setPatientOccupation(String patientOccupation) {
        this.patientOccupation = patientOccupation;
    }

    public String getPatientMarriage() {
        return patientMarriage;
    }

    public void setPatientMarriage(String patientMarriage) {
        this.patientMarriage = patientMarriage;
    }

    public String getPatientIcon() {
        return patientIcon;
    }

    public void setPatientIcon(String patientIcon) {
        this.patientIcon = patientIcon;
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
        PatientDTO other = (PatientDTO) that;
        return (this.getPatientId() == null ? other.getPatientId() == null : this.getPatientId().equals(other.getPatientId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPatientName() == null ? other.getPatientName() == null : this.getPatientName().equals(other.getPatientName()))
            && (this.getPatientSex() == null ? other.getPatientSex() == null : this.getPatientSex().equals(other.getPatientSex()))
            && (this.getPatientBorn() == null ? other.getPatientBorn() == null : this.getPatientBorn().equals(other.getPatientBorn()))
            && (this.getPatientNation() == null ? other.getPatientNation() == null : this.getPatientNation().equals(other.getPatientNation()))
            && (this.getBloodtype() == null ? other.getBloodtype() == null : this.getBloodtype().equals(other.getBloodtype()))
            && (this.getPatientOccupation() == null ? other.getPatientOccupation() == null : this.getPatientOccupation().equals(other.getPatientOccupation()))
            && (this.getPatientMarriage() == null ? other.getPatientMarriage() == null : this.getPatientMarriage().equals(other.getPatientMarriage()))
            && (this.getPatientIcon() == null ? other.getPatientIcon() == null : this.getPatientIcon().equals(other.getPatientIcon()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPatientId() == null) ? 0 : getPatientId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPatientName() == null) ? 0 : getPatientName().hashCode());
        result = prime * result + ((getPatientSex() == null) ? 0 : getPatientSex().hashCode());
        result = prime * result + ((getPatientBorn() == null) ? 0 : getPatientBorn().hashCode());
        result = prime * result + ((getPatientNation() == null) ? 0 : getPatientNation().hashCode());
        result = prime * result + ((getBloodtype() == null) ? 0 : getBloodtype().hashCode());
        result = prime * result + ((getPatientOccupation() == null) ? 0 : getPatientOccupation().hashCode());
        result = prime * result + ((getPatientMarriage() == null) ? 0 : getPatientMarriage().hashCode());
        result = prime * result + ((getPatientIcon() == null) ? 0 : getPatientIcon().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", patientId=").append(patientId);
        sb.append(", userId=").append(userId);
        sb.append(", patientName=").append(patientName);
        sb.append(", patientSex=").append(patientSex);
        sb.append(", patientBorn=").append(patientBorn);
        sb.append(", patientNation=").append(patientNation);
        sb.append(", bloodtype=").append(bloodtype);
        sb.append(", patientOccupation=").append(patientOccupation);
        sb.append(", patientMarriage=").append(patientMarriage);
        sb.append(", patientIcon=").append(patientIcon);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}