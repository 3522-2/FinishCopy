package com.example.yuan.modle;

public class Material {
    private int material_id;	//材料号	varchar(10 )
    private String material_name;	//材料名	varchar(10 )
    private String gmaterial_type;	//材料类型	varchar(10 )
    private String material_price;//	材料价格	varchar(10 )
    private String material_provider;	//材料供应商	varchar(10 )
    private String material_brand;	//材料品牌	varchar(225)
    private String material_photo;	//材料图片	blob

    public Material(int material_id, String material_name, String gmaterial_type, String material_price, String material_provider, String material_brand, byte[] material_photo){}
    public Material(int information_id, String information_user, String information_userTelephon, String information_address, String information_area, String information_type, String information_stytle){
        super();
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public String getGmaterial_type() {
        return gmaterial_type;
    }

    public void setGmaterial_type(String gmaterial_type) {
        this.gmaterial_type = gmaterial_type;
    }

    public String getMaterial_price() {
        return material_price;
    }

    public void setMaterial_price(String material_price) {
        this.material_price = material_price;
    }

    public String getMaterial_provider() {
        return material_provider;
    }

    public void setMaterial_provider(String material_provider) {
        this.material_provider = material_provider;
    }

    public String getMaterial_brand() {
        return material_brand;
    }

    public void setMaterial_brand(String material_brand) {
        this.material_brand = material_brand;
    }

    public String getMaterial_photo() {
        return material_photo;
    }

    public void setMaterial_photo(String material_photo) {
        this.material_photo = material_photo;
    }
}
