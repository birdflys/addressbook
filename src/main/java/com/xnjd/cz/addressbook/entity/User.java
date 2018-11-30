package com.xnjd.cz.addressbook.entity;

public class User {
    /*id编号*/
    private Integer id;
    /*姓名*/
    private String name;
    /*密码*/
    private String password;
    /*性别*/
    private String sex;
    /*年龄*/
    private Integer age;
    /*工作单位*/
    private String workUnits;
    /*电话号码*/
    private String phoneNumber;
    /*邮箱*/
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWorkUnits() {
        return workUnits;
    }

    public void setWorkUnits(String workUnits) {
        this.workUnits = workUnits;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", workUnits=" + workUnits +
                ", phoneNumber=" + phoneNumber +
                ", email=" + email +
                '}';
    }
}
