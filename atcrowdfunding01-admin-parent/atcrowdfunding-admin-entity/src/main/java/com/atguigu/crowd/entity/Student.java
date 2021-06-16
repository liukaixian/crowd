package com.atguigu.crowd.entity;

import java.util.List;
import java.util.Map;

public class Student {
    private String sId;
    private  String sName;
    private Address address;
    private List<Subject> subjectList;
    private Map<String,String> map;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", sName='" + sName + '\'' +
                ", address=" + address +
                ", subjectList=" + subjectList +
                ", map=" + map +
                '}';
    }

    public Student(String sId, String sName, Address address, List<Subject> subjectList, Map<String, String> map) {
        this.sId = sId;
        this.sName = sName;
        this.address = address;
        this.subjectList = subjectList;
        this.map = map;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
