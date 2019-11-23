package com.hyzz.pojo;

import lombok.Data;

import javax.persistence.*;

@Table(name = "tb_user")
@Data
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tele")
    private String tele;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    private String email;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "referrer_tele")
    private String referrerTele;
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "user_type_id")
    private Integer userTypeId;
    @Column(name = "origin_type_id")
    private Integer originTypeId;
    @Column(name = "company_type_id")
    private Integer companyTypeId;
    private String provinces;
    private String address;
    private String image;
    @Column(name = "business_id")
    private Integer businessId;
    private String wechat;
    private String qq;
    private int fulfilCount;
    @Column(name = "is_member")
    private int isMember;
    @Column(name = "is_certification")
    private int isCertification;
    @Column(name = "is_lock")
    private int isLock;
    @Column(name = "is_ban")
    private int isBan;

}
