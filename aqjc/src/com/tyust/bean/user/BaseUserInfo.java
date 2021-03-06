package com.tyust.bean.user;

import java.util.Date;

public class BaseUserInfo {

    private String userId;
    private String userName;
    private String sex;
    private Date birthday;
    private String unitId;
    private String duty;
    private String tecduty;
    private String password;
    private Short inuse;
    private String telephone;
    private String email;
    private String createUnitId;
    private String cardId;
    private String name;
    private String mobile;
    private String userComment;
    private Date createTime;
    private Date lastLoginTime;

    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.USER_ID
     *
     * @param userId the value for T_BASE_USER_INFO.USER_ID
     *
     * @ibatorgenerated
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.USER_NAME
     *
     * @return the value of T_BASE_USER_INFO.USER_NAME
     *
     * @ibatorgenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.USER_NAME
     *
     * @param userName the value for T_BASE_USER_INFO.USER_NAME
     *
     * @ibatorgenerated
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.SEX
     *
     * @return the value of T_BASE_USER_INFO.SEX
     *
     * @ibatorgenerated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.SEX
     *
     * @param sex the value for T_BASE_USER_INFO.SEX
     *
     * @ibatorgenerated
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.BIRTHDAY
     *
     * @return the value of T_BASE_USER_INFO.BIRTHDAY
     *
     * @ibatorgenerated
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.BIRTHDAY
     *
     * @param birthday the value for T_BASE_USER_INFO.BIRTHDAY
     *
     * @ibatorgenerated
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.UNIT_ID
     *
     * @return the value of T_BASE_USER_INFO.UNIT_ID
     *
     * @ibatorgenerated
     */
    public String getUnitId() {
        return unitId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.UNIT_ID
     *
     * @param unitId the value for T_BASE_USER_INFO.UNIT_ID
     *
     * @ibatorgenerated
     */
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.DUTY
     *
     * @return the value of T_BASE_USER_INFO.DUTY
     *
     * @ibatorgenerated
     */
    public String getDuty() {
        return duty;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.DUTY
     *
     * @param duty the value for T_BASE_USER_INFO.DUTY
     *
     * @ibatorgenerated
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.TECDUTY
     *
     * @return the value of T_BASE_USER_INFO.TECDUTY
     *
     * @ibatorgenerated
     */
    public String getTecduty() {
        return tecduty;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.TECDUTY
     *
     * @param tecduty the value for T_BASE_USER_INFO.TECDUTY
     *
     * @ibatorgenerated
     */
    public void setTecduty(String tecduty) {
        this.tecduty = tecduty;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.PASSWORD
     *
     * @return the value of T_BASE_USER_INFO.PASSWORD
     *
     * @ibatorgenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.PASSWORD
     *
     * @param password the value for T_BASE_USER_INFO.PASSWORD
     *
     * @ibatorgenerated
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.INUSE
     *
     * @return the value of T_BASE_USER_INFO.INUSE
     *
     * @ibatorgenerated
     */
    public Short getInuse() {
        return inuse;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.INUSE
     *
     * @param inuse the value for T_BASE_USER_INFO.INUSE
     *
     * @ibatorgenerated
     */
    public void setInuse(Short inuse) {
        this.inuse = inuse;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.TELEPHONE
     *
     * @return the value of T_BASE_USER_INFO.TELEPHONE
     *
     * @ibatorgenerated
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.TELEPHONE
     *
     * @param telephone the value for T_BASE_USER_INFO.TELEPHONE
     *
     * @ibatorgenerated
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.EMAIL
     *
     * @return the value of T_BASE_USER_INFO.EMAIL
     *
     * @ibatorgenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.EMAIL
     *
     * @param email the value for T_BASE_USER_INFO.EMAIL
     *
     * @ibatorgenerated
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.CREATE_UNIT_ID
     *
     * @return the value of T_BASE_USER_INFO.CREATE_UNIT_ID
     *
     * @ibatorgenerated
     */
    public String getCreateUnitId() {
        return createUnitId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.CREATE_UNIT_ID
     *
     * @param createUnitId the value for T_BASE_USER_INFO.CREATE_UNIT_ID
     *
     * @ibatorgenerated
     */
    public void setCreateUnitId(String createUnitId) {
        this.createUnitId = createUnitId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.CARD_ID
     *
     * @return the value of T_BASE_USER_INFO.CARD_ID
     *
     * @ibatorgenerated
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.CARD_ID
     *
     * @param cardId the value for T_BASE_USER_INFO.CARD_ID
     *
     * @ibatorgenerated
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.NAME
     *
     * @return the value of T_BASE_USER_INFO.NAME
     *
     * @ibatorgenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.NAME
     *
     * @param name the value for T_BASE_USER_INFO.NAME
     *
     * @ibatorgenerated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.MOBILE
     *
     * @return the value of T_BASE_USER_INFO.MOBILE
     *
     * @ibatorgenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.MOBILE
     *
     * @param mobile the value for T_BASE_USER_INFO.MOBILE
     *
     * @ibatorgenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.USER_COMMENT
     *
     * @return the value of T_BASE_USER_INFO.USER_COMMENT
     *
     * @ibatorgenerated
     */
    public String getUserComment() {
        return userComment;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.USER_COMMENT
     *
     * @param userComment the value for T_BASE_USER_INFO.USER_COMMENT
     *
     * @ibatorgenerated
     */
    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.CREATE_TIME
     *
     * @return the value of T_BASE_USER_INFO.CREATE_TIME
     *
     * @ibatorgenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.CREATE_TIME
     *
     * @param createTime the value for T_BASE_USER_INFO.CREATE_TIME
     *
     * @ibatorgenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_BASE_USER_INFO.LAST_LOGIN_TIME
     *
     * @return the value of T_BASE_USER_INFO.LAST_LOGIN_TIME
     *
     * @ibatorgenerated
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_BASE_USER_INFO.LAST_LOGIN_TIME
     *
     * @param lastLoginTime the value for T_BASE_USER_INFO.LAST_LOGIN_TIME
     *
     * @ibatorgenerated
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}