package com.test.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BasePojo implements Serializable {
    private static final long serialVersionUID = -7033620614035856181L;
    private Date created;
    private Date updated;
}
