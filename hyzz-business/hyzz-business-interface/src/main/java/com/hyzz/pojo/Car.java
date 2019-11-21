package com.hyzz.pojo;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_car")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int begin_id;

    private int end_id;

    private int vehicle_type_id;

    private Double vehicle_length;

    private int load_id;

    private String goods_type;

    private String transport_type;

    private Date expect_return_time;

    private String usetime;

    private String detail;

    private int load_type_id;

    private int line_type_id;

    private Long price;

    private String name;

    private String tel;

    private String email;

    private String qq;

    private int price_type_id;

    private int status_id;

}
