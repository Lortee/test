package com.example.ompatibility;

public class Recycler {

    private String name;
    private String sDesc;
    private int imageResource;

    public Recycler(String name, String sDesc, int imRes) {
        this.name = name;
        this.sDesc = sDesc;
        this.imageResource = imRes;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getsDesc(){
        return this.sDesc;
    }

    public void setsDesc(String name){
        this.sDesc = sDesc;
    }

    public int getImageResource() {
        return this.imageResource;
    }

    public void setImageResource(int flagResource) {
        this.imageResource = imageResource;
    }

}
