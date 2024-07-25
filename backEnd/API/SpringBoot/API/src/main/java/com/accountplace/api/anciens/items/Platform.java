package com.accountplace.api.anciens.items;

public class Platform {
    private int id;
    private String name;
    private String url;
    private String imgRef;

    public Platform(int id, String name, String url, String imgRef) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.imgRef = imgRef;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}
    public String getImgRef() {return imgRef;}
    public void setImgRef(String imgRef) {this.imgRef = imgRef;}


}
