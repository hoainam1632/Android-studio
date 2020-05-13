package com.example.rcv_getdatamysql;

public class SinhVien {
    private  String name;
    private String img;

    public SinhVien(String img, String name) {
        this.img = img;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
