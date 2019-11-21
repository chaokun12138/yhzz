package com.hyzz.pojo;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tele;
    private String password;
    private String name;
    private String email;
    private String companyName;
    private String referrerTele;
    private int roleId;
    private Integer userTypeId;
    private Integer originTypeId;
    private Integer companyTypeId;
    private String provinces;
    private String address;
    private String image;
    private Integer businessId;
    private String wechat;
    private String qq;
    private int fulfilCount;
    private byte isMember;
    private byte isCertification;
    private byte isLock;
    private byte isBan;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tele='" + tele + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                ", referrerTele='" + referrerTele + '\'' +
                ", roleId=" + roleId +
                ", userTypeId=" + userTypeId +
                ", originTypeId=" + originTypeId +
                ", companyTypeId=" + companyTypeId +
                ", provinces='" + provinces + '\'' +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                ", businessId=" + businessId +
                ", wechat='" + wechat + '\'' +
                ", qq='" + qq + '\'' +
                ", fulfilCount=" + fulfilCount +
                ", isMember=" + isMember +
                ", isCertification=" + isCertification +
                ", isLock=" + isLock +
                ", isBan=" + isBan +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tele")
    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "referrer_tele")
    public String getReferrerTele() {
        return referrerTele;
    }

    public void setReferrerTele(String referrerTele) {
        this.referrerTele = referrerTele;
    }

    @Basic
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "user_type_id")
    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Basic
    @Column(name = "origin_type_id")
    public Integer getOriginTypeId() {
        return originTypeId;
    }

    public void setOriginTypeId(Integer originTypeId) {
        this.originTypeId = originTypeId;
    }

    @Basic
    @Column(name = "company_type_id")
    public Integer getCompanyTypeId() {
        return companyTypeId;
    }

    public void setCompanyTypeId(Integer companyTypeId) {
        this.companyTypeId = companyTypeId;
    }

    @Basic
    @Column(name = "provinces")
    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "business_id")
    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    @Basic
    @Column(name = "wechat")
    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Basic
    @Column(name = "qq")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Basic
    @Column(name = "fulfil_count")
    public int getFulfilCount() {
        return fulfilCount;
    }

    public void setFulfilCount(int fulfilCount) {
        this.fulfilCount = fulfilCount;
    }

    @Basic
    @Column(name = "is_member")
    public byte getIsMember() {
        return isMember;
    }

    public void setIsMember(byte isMember) {
        this.isMember = isMember;
    }

    @Basic
    @Column(name = "is_certification")
    public byte getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(byte isCertification) {
        this.isCertification = isCertification;
    }

    @Basic
    @Column(name = "is_lock")
    public byte getIsLock() {
        return isLock;
    }

    public void setIsLock(byte isLock) {
        this.isLock = isLock;
    }

    @Basic
    @Column(name = "is_ban")
    public byte getIsBan() {
        return isBan;
    }

    public void setIsBan(byte isBan) {
        this.isBan = isBan;
    }


}
