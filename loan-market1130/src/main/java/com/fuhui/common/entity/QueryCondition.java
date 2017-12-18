package com.fuhui.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询条件实体类
 * @author Ren
 */
public class QueryCondition implements Serializable {

    /** 标签页*/
    private Integer onshelves;

    /** ID */
    private Integer ID;

    /** 用户ID */
    private Integer uid;

    /** 平台名 */
    private String platformName;
    /** 登录名字*/
    private String loginName;

    /** 身份证 */
    private String idcard;

    /** 名字 */
    private String name;

    /** 手机号 */
    private String mobile;

    /** 用户申请开始时间（区间）*/
    private Date startTime;

    /** 用户申请结束时间（区间）*/
    private Date endTime;

    /** 用户申请结果 */
    private String applicationResult;

    /** 工作名 */
    private String job;

    /** 是否查询今天 0-否 1-是 */
    private Integer isQueryToday;

    /** 是否查询昨天 0-否 1-是 */
    private Integer isQueryYesterday;

    private Integer find;
    /** 管理员状态*/
    private Byte userStatus;

    public Byte getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getOnshelves() {
        return onshelves;
    }

    public void setOnshelves(Integer onshelves) {
        this.onshelves = onshelves;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getApplicationResult() {
        return applicationResult;
    }

    public void setApplicationResult(String applicationResult) {
        this.applicationResult = applicationResult;
    }

    public Integer getIsQueryToday() {
        return isQueryToday;
    }

    public void setIsQueryToday(Integer isQueryToday) {
        this.isQueryToday = isQueryToday;
    }

    public Integer getIsQueryYesterday() {
        return isQueryYesterday;
    }

    public void setIsQueryYesterday(Integer isQueryYesterday) {
        this.isQueryYesterday = isQueryYesterday;
    }

    public Integer getFind() {
        return find;
    }

    public void setFind(Integer find) {
        this.find = find;
    }
}