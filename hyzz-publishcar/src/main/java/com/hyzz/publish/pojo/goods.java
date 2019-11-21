package com.hyzz.publish.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_goods")
public class goods {

    @Id
    private Integer id;
    private Integer goods_type_id;
    private String goods_name;
    private String goods_class;
    private Integer goods_num;
    private String line_type;
    private String goods_from;
    private String goods_to;
    private Double price;
    private String name;
    private String tel;
    private String email;
    private String qq;
    private String status;

}
