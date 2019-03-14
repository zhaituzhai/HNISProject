package com.zhaojm.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 
 */
public class InformationDTO implements Serializable {
    @ApiModelProperty("资讯主键")
    private Integer informationId;

    @ApiModelProperty("上传时间")
    private String informationTime;

    @ApiModelProperty("上传作者")
    private String informationAuthor;

    @ApiModelProperty("资讯标题（50字以内）")
    private String informationTitle;

    @ApiModelProperty("资讯内容")
    private String informationMain;

    @ApiModelProperty("资讯标签")
    private String informationLabel;

    @ApiModelProperty("上传人")
    private Integer entryPorson;

    private static final long serialVersionUID = 1L;

    public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    public String getInformationTime() {
        return informationTime;
    }

    public void setInformationTime(String informationTime) {
        this.informationTime = informationTime;
    }

    public String getInformationAuthor() {
        return informationAuthor;
    }

    public void setInformationAuthor(String informationAuthor) {
        this.informationAuthor = informationAuthor;
    }

    public String getInformationTitle() {
        return informationTitle;
    }

    public void setInformationTitle(String informationTitle) {
        this.informationTitle = informationTitle;
    }

    public String getInformationMain() {
        return informationMain;
    }

    public void setInformationMain(String informationMain) {
        this.informationMain = informationMain;
    }

    public String getInformationLabel() {
        return informationLabel;
    }

    public void setInformationLabel(String informationLabel) {
        this.informationLabel = informationLabel;
    }

    public Integer getEntryPorson() {
        return entryPorson;
    }

    public void setEntryPorson(Integer entryPorson) {
        this.entryPorson = entryPorson;
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
        InformationDTO other = (InformationDTO) that;
        return (this.getInformationId() == null ? other.getInformationId() == null : this.getInformationId().equals(other.getInformationId()))
            && (this.getInformationTime() == null ? other.getInformationTime() == null : this.getInformationTime().equals(other.getInformationTime()))
            && (this.getInformationAuthor() == null ? other.getInformationAuthor() == null : this.getInformationAuthor().equals(other.getInformationAuthor()))
            && (this.getInformationTitle() == null ? other.getInformationTitle() == null : this.getInformationTitle().equals(other.getInformationTitle()))
            && (this.getInformationMain() == null ? other.getInformationMain() == null : this.getInformationMain().equals(other.getInformationMain()))
            && (this.getInformationLabel() == null ? other.getInformationLabel() == null : this.getInformationLabel().equals(other.getInformationLabel()))
            && (this.getEntryPorson() == null ? other.getEntryPorson() == null : this.getEntryPorson().equals(other.getEntryPorson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInformationId() == null) ? 0 : getInformationId().hashCode());
        result = prime * result + ((getInformationTime() == null) ? 0 : getInformationTime().hashCode());
        result = prime * result + ((getInformationAuthor() == null) ? 0 : getInformationAuthor().hashCode());
        result = prime * result + ((getInformationTitle() == null) ? 0 : getInformationTitle().hashCode());
        result = prime * result + ((getInformationMain() == null) ? 0 : getInformationMain().hashCode());
        result = prime * result + ((getInformationLabel() == null) ? 0 : getInformationLabel().hashCode());
        result = prime * result + ((getEntryPorson() == null) ? 0 : getEntryPorson().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", informationId=").append(informationId);
        sb.append(", informationTime=").append(informationTime);
        sb.append(", informationAuthor=").append(informationAuthor);
        sb.append(", informationTitle=").append(informationTitle);
        sb.append(", informationMain=").append(informationMain);
        sb.append(", informationLabel=").append(informationLabel);
        sb.append(", entryPorson=").append(entryPorson);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}