package com.etjava.model;

public class Teacher {
    private Integer id;
    private String teaName;
    private Integer teaAge;
    private String curriculum;
    private byte[] pic;// blob 字节形式
    private String remark;// clob 字符串

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public Integer getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(Integer teaAge) {
        this.teaAge = teaAge;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teaName='" + teaName + '\'' +
                ", teaAge=" + teaAge +
                ", curriculum='" + curriculum + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
