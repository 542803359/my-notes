package com.xiaowenxing.utils.multisource;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaowx
 * @date 2021/12/31 14:58
 **/
@Data
public class RatioPaginationParam implements Serializable {
    private static final long serialVersionUID = -1496754980781572809L;

    /**
     * 总条数
     */
    private int allCount;

    /**
     * 优先总条数 以一个优先数据源条数作为优先条数,比如有两个list,先从一个list取,从另一个list补充,那么第一个list就是优先数据源
     */
    private int priorityCount;

    /**
     * 优先数据每页展示长度比率 （重点：优先数据比率,比如第一个优先数据源占比40%,则60%从第二个list补充,则此处填写40）
     */
    private int ratio;

    /**
     * 当前页 用户请求当前页,起始页为:1
     */
    private int current;

    /**
     * 每页展示 用户请求每页展示
     */
    private int pageSize;
}