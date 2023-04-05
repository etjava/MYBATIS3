package com.etjava.model;

public class Address {
    private Integer id;
    private String sheng;
    private String shi;
    private String qu;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public void setQu(String qu) {
        this.qu = qu;
    }

    public Integer getId() {
        return id;
    }

    public String getSheng() {
        return sheng;
    }

    public String getShi() {
        return shi;
    }

    public String getQu() {
        return qu;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", sheng='" + sheng + '\'' +
                ", shi='" + shi + '\'' +
                ", qu='" + qu + '\'' +
                '}';
    }
}
