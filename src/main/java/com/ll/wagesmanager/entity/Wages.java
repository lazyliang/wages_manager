package com.ll.wagesmanager.entity;

/**
 * Create by ll on 2018/3/30.
 */
public class Wages {
    private String id; //id
    private Integer num; //员工编号
    private String year; //工资年份
    private String month; //工资月份
    private Integer baseWages; //基本工资
    private Integer addtion; //津贴
    private Integer overTime; //加班工资
    private Integer sum; //总工资
    private String userId; //用户ID
    private Integer ycqts; //出勤天数
    private Integer yk;

    public Integer getYk() {
        return yk;
    }

    public void setYk(Integer yk) {
        this.yk = yk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBaseWages() {
        return baseWages;
    }

    public void setBaseWages(Integer baseWages) {
        this.baseWages = baseWages;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


    public Integer getAddtion() {
        return addtion;
    }

    public void setAddtion(Integer addtion) {
        this.addtion = addtion;
    }

    public Integer getOverTime() {
        return overTime;
    }

    public void setOverTime(Integer overTime) {
        this.overTime = overTime;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getYcqts() {
        return ycqts;
    }

    public void setYcqts(Integer ycqts) {
        this.ycqts = ycqts;
    }
}
