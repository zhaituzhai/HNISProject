package com.zhaojm.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 
 */
public class DoctorDTO implements Serializable {
    @ApiModelProperty("医生主键")
    private Integer doctorId;

    @ApiModelProperty("关联用户id")
    private Integer userId;

    @ApiModelProperty("医生名")
    private String doctorName;

    @ApiModelProperty("性别")
    private String doctorSex;

    @ApiModelProperty("所属科室")
    private String departementId;

    @ApiModelProperty("医生头衔")
    private String doctorTitle;

    @ApiModelProperty("所属医院")
    private String doctorHospital;

    @ApiModelProperty("医生照片")
    private String doctorIcon;

    private static final long serialVersionUID = 1L;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSex() {
        return doctorSex;
    }

    public void setDoctorSex(String doctorSex) {
        this.doctorSex = doctorSex;
    }

    public String getDepartementId() {
        return departementId;
    }

    public void setDepartementId(String departementId) {
        this.departementId = departementId;
    }

    public String getDoctorTitle() {
        return doctorTitle;
    }

    public void setDoctorTitle(String doctorTitle) {
        this.doctorTitle = doctorTitle;
    }

    public String getDoctorHospital() {
        return doctorHospital;
    }

    public void setDoctorHospital(String doctorHospital) {
        this.doctorHospital = doctorHospital;
    }

    public String getDoctorIcon() {
        return doctorIcon;
    }

    public void setDoctorIcon(String doctorIcon) {
        this.doctorIcon = doctorIcon;
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
        DoctorDTO other = (DoctorDTO) that;
        return (this.getDoctorId() == null ? other.getDoctorId() == null : this.getDoctorId().equals(other.getDoctorId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDoctorName() == null ? other.getDoctorName() == null : this.getDoctorName().equals(other.getDoctorName()))
            && (this.getDoctorSex() == null ? other.getDoctorSex() == null : this.getDoctorSex().equals(other.getDoctorSex()))
            && (this.getDepartementId() == null ? other.getDepartementId() == null : this.getDepartementId().equals(other.getDepartementId()))
            && (this.getDoctorTitle() == null ? other.getDoctorTitle() == null : this.getDoctorTitle().equals(other.getDoctorTitle()))
            && (this.getDoctorHospital() == null ? other.getDoctorHospital() == null : this.getDoctorHospital().equals(other.getDoctorHospital()))
            && (this.getDoctorIcon() == null ? other.getDoctorIcon() == null : this.getDoctorIcon().equals(other.getDoctorIcon()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDoctorId() == null) ? 0 : getDoctorId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDoctorName() == null) ? 0 : getDoctorName().hashCode());
        result = prime * result + ((getDoctorSex() == null) ? 0 : getDoctorSex().hashCode());
        result = prime * result + ((getDepartementId() == null) ? 0 : getDepartementId().hashCode());
        result = prime * result + ((getDoctorTitle() == null) ? 0 : getDoctorTitle().hashCode());
        result = prime * result + ((getDoctorHospital() == null) ? 0 : getDoctorHospital().hashCode());
        result = prime * result + ((getDoctorIcon() == null) ? 0 : getDoctorIcon().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", doctorId=").append(doctorId);
        sb.append(", userId=").append(userId);
        sb.append(", doctorName=").append(doctorName);
        sb.append(", doctorSex=").append(doctorSex);
        sb.append(", departementId=").append(departementId);
        sb.append(", doctorTitle=").append(doctorTitle);
        sb.append(", doctorHospital=").append(doctorHospital);
        sb.append(", doctorIcon=").append(doctorIcon);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}