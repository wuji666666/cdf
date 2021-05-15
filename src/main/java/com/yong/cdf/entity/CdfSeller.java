package com.yong.cdf.entity;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * @ClassName: User
 * @Description: 用户字段
 * @Author
 * @Date 2021/5/10
 * @Time 22:39
 * @Version 1.0
 */

@Data
@Repository
public class CdfSeller {

    private String user_id;

    private String username;

    private String password;

    private String phone_number;

    private String email;

    private LocalDateTime create_time;

    private  LocalDateTime update_time;

}
