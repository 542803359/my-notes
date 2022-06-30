package com.xiaowenxing.utils.multisource;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaowx
 * @date 2021/12/31 14:57
 **/
@Data
public class RatioPagination implements Serializable {
    private static final long serialVersionUID = 6722234949377171106L;

    /**
     * 优先 limit 开始 即从第几条开始取 eg: 8->从第八条开始取
     */
    private int priorityLimitStart;
    /**
     * 优先limit 长度 即取的数量,eg:3->取3条 10->取10条
     */
    private int prioritySize;
    /**
     * 非优先limit 开始
     */
    private int nonPriorityLimitStart;
    /**
     * 非优先limit 长度
     */
    private int nonPrioritySize;

    public RatioPagination(int priorityLimitStart,int prioritySize,int nonPriorityLimitStart,int nonPrioritySize){
        this.priorityLimitStart = priorityLimitStart;
        this.prioritySize = prioritySize;
        this.nonPriorityLimitStart = nonPriorityLimitStart;
        this.nonPrioritySize = nonPrioritySize;

    }
}