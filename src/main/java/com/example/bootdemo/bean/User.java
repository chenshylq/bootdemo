package com.example.bootdemo.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Chenchenx
 * @version v1.0
 * @date 2021/12/119:26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
