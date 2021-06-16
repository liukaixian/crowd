package com.atguigu.crowd.entity;

public class Subject {
    private String subjectName;
    private int sScore;

    public Subject() {
    }

    public Subject(String subjectName, int sScore) {
        this.subjectName = subjectName;
        this.sScore = sScore;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getsScore() {
        return sScore;
    }

    public void setsScore(int sScore) {
        this.sScore = sScore;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", sScore=" + sScore +
                '}';
    }
}
