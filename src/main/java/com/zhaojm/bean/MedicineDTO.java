package com.zhaojm.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 
 */
public class MedicineDTO implements Serializable {
    @ApiModelProperty("药品id")
    private Integer medicineId;

    @ApiModelProperty("药品名字")
    private String medicineName;

    @ApiModelProperty("主要成分")
    private String mainComponents;

    @ApiModelProperty("使用范围")
    private String userRange;

    @ApiModelProperty("使用方法")
    private String userWay;

    @ApiModelProperty("注意事项")
    private String userAttention;

    @ApiModelProperty("贮藏方式")
    private String saveWay;

    @ApiModelProperty("规格")
    private String specifications;

    @ApiModelProperty("单价")
    private BigDecimal price;

    private static final long serialVersionUID = 1L;

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMainComponents() {
        return mainComponents;
    }

    public void setMainComponents(String mainComponents) {
        this.mainComponents = mainComponents;
    }

    public String getUserRange() {
        return userRange;
    }

    public void setUserRange(String userRange) {
        this.userRange = userRange;
    }

    public String getUserWay() {
        return userWay;
    }

    public void setUserWay(String userWay) {
        this.userWay = userWay;
    }

    public String getUserAttention() {
        return userAttention;
    }

    public void setUserAttention(String userAttention) {
        this.userAttention = userAttention;
    }

    public String getSaveWay() {
        return saveWay;
    }

    public void setSaveWay(String saveWay) {
        this.saveWay = saveWay;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        MedicineDTO other = (MedicineDTO) that;
        return (this.getMedicineId() == null ? other.getMedicineId() == null : this.getMedicineId().equals(other.getMedicineId()))
            && (this.getMedicineName() == null ? other.getMedicineName() == null : this.getMedicineName().equals(other.getMedicineName()))
            && (this.getMainComponents() == null ? other.getMainComponents() == null : this.getMainComponents().equals(other.getMainComponents()))
            && (this.getUserRange() == null ? other.getUserRange() == null : this.getUserRange().equals(other.getUserRange()))
            && (this.getUserWay() == null ? other.getUserWay() == null : this.getUserWay().equals(other.getUserWay()))
            && (this.getUserAttention() == null ? other.getUserAttention() == null : this.getUserAttention().equals(other.getUserAttention()))
            && (this.getSaveWay() == null ? other.getSaveWay() == null : this.getSaveWay().equals(other.getSaveWay()))
            && (this.getSpecifications() == null ? other.getSpecifications() == null : this.getSpecifications().equals(other.getSpecifications()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMedicineId() == null) ? 0 : getMedicineId().hashCode());
        result = prime * result + ((getMedicineName() == null) ? 0 : getMedicineName().hashCode());
        result = prime * result + ((getMainComponents() == null) ? 0 : getMainComponents().hashCode());
        result = prime * result + ((getUserRange() == null) ? 0 : getUserRange().hashCode());
        result = prime * result + ((getUserWay() == null) ? 0 : getUserWay().hashCode());
        result = prime * result + ((getUserAttention() == null) ? 0 : getUserAttention().hashCode());
        result = prime * result + ((getSaveWay() == null) ? 0 : getSaveWay().hashCode());
        result = prime * result + ((getSpecifications() == null) ? 0 : getSpecifications().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", medicineId=").append(medicineId);
        sb.append(", medicineName=").append(medicineName);
        sb.append(", mainComponents=").append(mainComponents);
        sb.append(", userRange=").append(userRange);
        sb.append(", userWay=").append(userWay);
        sb.append(", userAttention=").append(userAttention);
        sb.append(", saveWay=").append(saveWay);
        sb.append(", specifications=").append(specifications);
        sb.append(", price=").append(price);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}