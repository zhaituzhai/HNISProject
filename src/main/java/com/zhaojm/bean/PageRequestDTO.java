package com.zhaojm.bean;

import java.io.Serializable;

public class PageRequestDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /***
     * 请求实际参数
     */
    protected T param;

    private Integer pageNum;

    private Integer pageSize;

    public T getParam() {
        return param;
    }

    public void setParam(T value) {
        this.param = value;
    }

    public PageRequestDTO() {
        super();
    }

    public PageRequestDTO(T value, Integer pageSzie) {
        super();
        this.setPageSize(pageSzie);
        this.param = param;
    }

    public PageRequestDTO(T param) {
        super();
        this.param = param;
    }

    public PageRequestDTO(T param, Integer pageNum, Integer pageSzie) {
        super();
        this.setPageNum(pageNum);
        this.setPageSize(pageSzie);
        this.param = param;
    }

    public Integer getPageNum() {
        return pageNum == null ? 1 : pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
