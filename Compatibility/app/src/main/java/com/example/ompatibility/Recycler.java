package com.example.ompatibility;

public class Recycler {

    private String name; //имя
    private String sDesc; //краткое описание
    private int imageResource; //ссылка на ресурс изображения

    //конструктор
    public Recycler(String name, String sDesc, int imRes) {
        this.name = name;
        this.sDesc = sDesc;
        this.imageResource = imRes;
    }

    //сеттеры и геттеры
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getsDesc(){
        return this.sDesc;
    }

    public void setsDesc(String sDesc){
        this.sDesc = sDesc;
    }

    public int getImageResource() {
        return this.imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

}
