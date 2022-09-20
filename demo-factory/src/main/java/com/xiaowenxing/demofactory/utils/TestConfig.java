package com.xiaowenxing.demofactory.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 测试配置
 *
 * @author xiaowx
 * @date 2022/09/20 15:00:44
 */
@Data
public class TestConfig implements Serializable {

    private static final long serialVersionUID = -6541180061782004705L;

    private String tokenName;
}
