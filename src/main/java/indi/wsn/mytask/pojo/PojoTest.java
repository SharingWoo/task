package indi.wsn.mytask.pojo;

import java.io.Serializable;

/**
 * FileName: PojoTest.java
 * 普通pojo
 *
 * @author SharingWoo
 * @version 1.00
 * @Date 2017/4/13
 */
public class PojoTest implements Serializable{
    private String name;
    private Integer age;
    private String address;
    private Integer hight;
    private String xex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getHight() {
        return hight;
    }

    public void setHight(Integer hight) {
        this.hight = hight;
    }

    public String getXex() {
        return xex;
    }

    public void setXex(String xex) {
        this.xex = xex;
    }

    @Override
    public String toString() {
        return "PojoTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", hight=" + hight +
                ", xex='" + xex + '\'' +
                '}';
    }
}
