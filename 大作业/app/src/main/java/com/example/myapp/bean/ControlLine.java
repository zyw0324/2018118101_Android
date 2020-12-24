package com.example.myapp.bean;

import java.io.Serializable;

public class ControlLine implements Serializable {
    private int controlLine;//省控线
    private String areaName;//省份名
    private String batchName;
    private String categoryName;
    private String controlDay;

    public int getControlLine() {
        return controlLine;
    }

    public void setControlLine(int controlLine) {
        this.controlLine = controlLine;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getControlDay() {
        return controlDay;
    }

    public void setControlDay(String controlDay) {
        this.controlDay = controlDay;
    }

    @Override
    public String toString() {
        return "ControlLine [cotrolLine=" + controlLine +
                ", areaName=" + areaName + '\'' +
                ", batchName=" + batchName + '\'' +
                ",categoryName=" + categoryName + '\''+
                ", controlYear=" + controlDay +
                "]";
    }

}
