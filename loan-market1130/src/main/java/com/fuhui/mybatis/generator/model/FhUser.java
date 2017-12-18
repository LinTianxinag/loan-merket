package com.fuhui.mybatis.generator.model;

import java.io.Serializable;
import java.util.Date;

public class FhUser implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.id
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.name
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.nick_name
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private String nickName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.idcard
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private String idcard;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.mobile
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.loan_amount
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private Long loanAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.loan_count
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private Integer loanCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.status
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.securitykey
     *
     * @mbggenerated Mon Dec 04 19:40:11 CST 2017
     */
    private String securitykey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.pwd
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private String pwd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.create_time
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.login_times
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private Integer loginTimes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fh_user.route
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private Integer route;

    private Integer view_count;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fh_user
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.id
     *
     * @return the value of fh_user.id
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.id
     *
     * @param id the value for fh_user.id
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.name
     *
     * @return the value of fh_user.name
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.name
     *
     * @param name the value for fh_user.name
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.nick_name
     *
     * @return the value of fh_user.nick_name
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.nick_name
     *
     * @param nickName the value for fh_user.nick_name
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.idcard
     *
     * @return the value of fh_user.idcard
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.idcard
     *
     * @param idcard the value for fh_user.idcard
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.mobile
     *
     * @return the value of fh_user.mobile
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.mobile
     *
     * @param mobile the value for fh_user.mobile
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.loan_amount
     *
     * @return the value of fh_user.loan_amount
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public Long getLoanAmount() {
        return loanAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.loan_amount
     *
     * @param loanAmount the value for fh_user.loan_amount
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.loan_count
     *
     * @return the value of fh_user.loan_count
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public Integer getLoanCount() {
        return loanCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.loan_count
     *
     * @param loanCount the value for fh_user.loan_count
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public void setLoanCount(Integer loanCount) {
        this.loanCount = loanCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.status
     *
     * @return the value of fh_user.status
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.status
     *
     * @param status the value for fh_user.status
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.securitykey
     *
     * @return the value of fh_user.securitykey
     *
     * @mbggenerated Mon Dec 04 19:40:11 CST 2017
     */
    public String getSecuritykey() {
        return securitykey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.securitykey
     *
     * @param securitykey the value for fh_user.securitykey
     *
     * @mbggenerated Mon Dec 04 19:40:11 CST 2017
     */
    public void setSecuritykey(String securitykey) {
        this.securitykey = securitykey == null ? null : securitykey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.pwd
     *
     * @return the value of fh_user.pwd
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.pwd
     *
     * @param pwd the value for fh_user.pwd
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.create_time
     *
     * @return the value of fh_user.create_time
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.create_time
     *
     * @param createTime the value for fh_user.create_time
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.login_times
     *
     * @return the value of fh_user.login_times
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public Integer getLoginTimes() {
        return loginTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.login_times
     *
     * @param loginTimes the value for fh_user.login_times
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fh_user.route
     *
     * @return the value of fh_user.route
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public Integer getRoute() {
        return route;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fh_user.route
     *
     * @param route the value for fh_user.route
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */
    public void setRoute(Integer route) {
        this.route = route;
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fh_user
     *
     * @mbggenerated Sat Dec 02 16:50:41 CST 2017
     */

}