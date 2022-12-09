package com.xiaowenxing.shardingsphere.domin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * 用户
 *
 * @author xiaowx
 * @date 2022/12/07 17:21:09
 */
@Data
@TableName("simple_data")
@Accessors(chain = true)
public class SimpleData implements Serializable {

    private static final long serialVersionUID = -6237334034242149609L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private Long userId;

    private Integer loginType;

}
