package com.xiaowenxing.demoproxy.domin;

import com.xiaowenxing.demoproxy.annotation.ParamMark;
import lombok.Data;

/**
 * 用户信息返回类
 *
 * @author xiaowx
 * @date 2022/4/7 13:40
 **/
@Data
public class UserVO {

    private String nickName;

    private Long userId;

    @ParamMark
    private String avatar;
}
