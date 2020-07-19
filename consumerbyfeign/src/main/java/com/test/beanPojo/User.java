package com.test.beanPojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 6850873642981992101L;
    private long id;
    private String username;
    private String password;
    private String phone;
    private String email;
}
