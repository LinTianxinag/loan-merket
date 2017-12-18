package com.fuhui.mybatis.sys.model;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.user_id
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.login_name
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private String loginName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.role_id
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private Integer roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.user_pwd
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private String userPwd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.real_name
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private String realName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.delete_flag
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private Byte deleteFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.last_ip
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private String lastIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.last_login_time
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private Date lastLoginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.login_times
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private Integer loginTimes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.user_status
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private Byte userStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.mobile
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.job
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private String job;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_user
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.user_id
     *
     * @return the value of sys_user.user_id
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.user_id
     *
     * @param userId the value for sys_user.user_id
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.login_name
     *
     * @return the value of sys_user.login_name
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.login_name
     *
     * @param loginName the value for sys_user.login_name
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.role_id
     *
     * @return the value of sys_user.role_id
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.role_id
     *
     * @param roleId the value for sys_user.role_id
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.user_pwd
     *
     * @return the value of sys_user.user_pwd
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.user_pwd
     *
     * @param userPwd the value for sys_user.user_pwd
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.real_name
     *
     * @return the value of sys_user.real_name
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.real_name
     *
     * @param realName the value for sys_user.real_name
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.delete_flag
     *
     * @return the value of sys_user.delete_flag
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.delete_flag
     *
     * @param deleteFlag the value for sys_user.delete_flag
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.last_ip
     *
     * @return the value of sys_user.last_ip
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.last_ip
     *
     * @param lastIp the value for sys_user.last_ip
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp == null ? null : lastIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.last_login_time
     *
     * @return the value of sys_user.last_login_time
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.last_login_time
     *
     * @param lastLoginTime the value for sys_user.last_login_time
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.login_times
     *
     * @return the value of sys_user.login_times
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public Integer getLoginTimes() {
        return loginTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.login_times
     *
     * @param loginTimes the value for sys_user.login_times
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.user_status
     *
     * @return the value of sys_user.user_status
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public Byte getUserStatus() {
        return userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.user_status
     *
     * @param userStatus the value for sys_user.user_status
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.mobile
     *
     * @return the value of sys_user.mobile
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.mobile
     *
     * @param mobile the value for sys_user.mobile
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.job
     *
     * @return the value of sys_user.job
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public String getJob() {
        return job;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.job
     *
     * @param job the value for sys_user.job
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysUser other = (SysUser) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getUserPwd() == null ? other.getUserPwd() == null : this.getUserPwd().equals(other.getUserPwd()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()))
            && (this.getLastIp() == null ? other.getLastIp() == null : this.getLastIp().equals(other.getLastIp()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getLoginTimes() == null ? other.getLoginTimes() == null : this.getLoginTimes().equals(other.getLoginTimes()))
            && (this.getUserStatus() == null ? other.getUserStatus() == null : this.getUserStatus().equals(other.getUserStatus()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getJob() == null ? other.getJob() == null : this.getJob().equals(other.getJob()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getUserPwd() == null) ? 0 : getUserPwd().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        result = prime * result + ((getLastIp() == null) ? 0 : getLastIp().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getLoginTimes() == null) ? 0 : getLoginTimes().hashCode());
        result = prime * result + ((getUserStatus() == null) ? 0 : getUserStatus().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getJob() == null) ? 0 : getJob().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbggenerated Sat Dec 02 16:29:53 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", loginName=").append(loginName);
        sb.append(", roleId=").append(roleId);
        sb.append(", userPwd=").append(userPwd);
        sb.append(", realName=").append(realName);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", lastIp=").append(lastIp);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", loginTimes=").append(loginTimes);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", mobile=").append(mobile);
        sb.append(", job=").append(job);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}