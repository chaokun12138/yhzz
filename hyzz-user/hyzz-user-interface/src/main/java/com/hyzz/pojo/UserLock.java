package com.hyzz.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tb_user_lock", schema = "hyzz")
@Data
public class UserLock {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "lock_time")
    private Date lockTime;
    @Column(name = "lock_duration")
    private float lockDuration;
    @Column(name = "complain_count")
    private int complainCount;

    @Override
    public String toString() {
        return "UserLock{" +
                "userId=" + userId +
                ", lockTime=" + lockTime +
                ", lockDuration=" + lockDuration +
                ", complainCount=" + complainCount +
                '}';
    }

}
