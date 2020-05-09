package cn.itcast.Domain;

import java.util.Date;
//Emp表的domain类
public class Emp {
    private Integer id;
    private String ename;
    private Integer job_id;
    private Integer mgr;
    private Date joindate;
    private Double salary;
    private Double bonus;
    private Integer dept_id;
    public Integer getId() {
        return id;
    }
    public String getEname() {
        return ename;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public Integer getMgr() {
        return mgr;
    }

    public Date getJoindate() {
        return joindate;
    }

    public Double getSalary() {
        return salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", job_id=" + job_id +
                ", mgr=" + mgr +
                ", joindate=" + joindate +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", dept_id=" + dept_id +
                '}';
    }
}