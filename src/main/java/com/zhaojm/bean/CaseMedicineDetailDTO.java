package com.zhaojm.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 
 */
public class CaseMedicineDetailDTO implements Serializable {
    @ApiModelProperty("病例用药详情主键")
    private Integer caseMedicineId;

    @ApiModelProperty("关联病例id")
    private Integer caseId;

    @ApiModelProperty("药品名/id")
    private String medicineName;

    @ApiModelProperty("用量")
    private String consumption;

    @ApiModelProperty("单价")
    private BigDecimal price;

    @ApiModelProperty("总价")
    private BigDecimal totalPrice;

    private static final long serialVersionUID = 1L;

    public Integer getCaseMedicineId() {
        return caseMedicineId;
    }

    public void setCaseMedicineId(Integer caseMedicineId) {
        this.caseMedicineId = caseMedicineId;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
        CaseMedicineDetailDTO other = (CaseMedicineDetailDTO) that;
        return (this.getCaseMedicineId() == null ? other.getCaseMedicineId() == null : this.getCaseMedicineId().equals(other.getCaseMedicineId()))
            && (this.getCaseId() == null ? other.getCaseId() == null : this.getCaseId().equals(other.getCaseId()))
            && (this.getMedicineName() == null ? other.getMedicineName() == null : this.getMedicineName().equals(other.getMedicineName()))
            && (this.getConsumption() == null ? other.getConsumption() == null : this.getConsumption().equals(other.getConsumption()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCaseMedicineId() == null) ? 0 : getCaseMedicineId().hashCode());
        result = prime * result + ((getCaseId() == null) ? 0 : getCaseId().hashCode());
        result = prime * result + ((getMedicineName() == null) ? 0 : getMedicineName().hashCode());
        result = prime * result + ((getConsumption() == null) ? 0 : getConsumption().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", caseMedicineId=").append(caseMedicineId);
        sb.append(", caseId=").append(caseId);
        sb.append(", medicineName=").append(medicineName);
        sb.append(", consumption=").append(consumption);
        sb.append(", price=").append(price);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}