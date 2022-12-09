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
@TableName("shard_user")
@Accessors(chain = true)
public class ShardUser implements Serializable {

    private static final long serialVersionUID = 7225044987643674492L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String userName;

    private String pwd;

}
