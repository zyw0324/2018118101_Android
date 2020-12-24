package com.example.myapp.bean;

public class Spot {
    private String name;
    private String describe;
    private int imageId;

    public Spot(String name,String describe, int imageId){
        this.name=name;
        this.describe=describe;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }

    public String getDescribe(){
        return describe;
    }

    public int getImageId(){
        return imageId;
    }
}
