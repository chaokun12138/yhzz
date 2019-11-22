package com.hyzz.publish.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "tb_car")
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private Integer beginId;
    private Integer endId;
    private Integer vehicleTypeId;
    private Double vehicleLength;
    private Integer loadId;
    private String  goodsType;
    private String transportType;
    private Date expectReturnTime;
    private String usetime;
    private String detail;
    private Integer loadTypeId;
    private Integer lineTypeId;
    private Double price;
    private String name;
    private String tel;
    private String email;
    private String qq;
    private Integer priceTypeId;
    private Integer statusId;


}
