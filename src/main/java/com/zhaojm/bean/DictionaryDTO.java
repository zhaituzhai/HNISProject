package com.zhaojm.bean;

import java.io.Serializable;

import org.springframework.boot.test.mock.mockito.MockBean;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 
 */
@MockBean
public class DictionaryDTO implements Serializable {
    @ApiModelProperty("字典主键")
    private Integer dictionaryId;

    @ApiModelProperty("数据码")
    private Integer dataCode;

    @ApiModelProperty("数据类型")
    private String dataType;

    @ApiModelProperty("数据值")
    private String dataValue;

    private static final long serialVersionUID = 1L;

    public Integer getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Integer dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public Integer getDataCode() {
        return dataCode;
    }

    public void setDataCode(Integer dataCode) {
        this.dataCode = dataCode;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
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
        DictionaryDTO other = (DictionaryDTO) that;
        return (this.getDictionaryId() == null ? other.getDictionaryId() == null : this.getDictionaryId().equals(other.getDictionaryId()))
            && (this.getDataCode() == null ? other.getDataCode() == null : this.getDataCode().equals(other.getDataCode()))
            && (this.getDataType() == null ? other.getDataType() == null : this.getDataType().equals(other.getDataType()))
            && (this.getDataValue() == null ? other.getDataValue() == null : this.getDataValue().equals(other.getDataValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDictionaryId() == null) ? 0 : getDictionaryId().hashCode());
        result = prime * result + ((getDataCode() == null) ? 0 : getDataCode().hashCode());
        result = prime * result + ((getDataType() == null) ? 0 : getDataType().hashCode());
        result = prime * result + ((getDataValue() == null) ? 0 : getDataValue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dictionaryId=").append(dictionaryId);
        sb.append(", dataCode=").append(dataCode);
        sb.append(", dataType=").append(dataType);
        sb.append(", dataValue=").append(dataValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}