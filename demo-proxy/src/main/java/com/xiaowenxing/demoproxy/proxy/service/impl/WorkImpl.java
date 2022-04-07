package com.xiaowenxing.demoproxy.proxy.service.impl;

import com.xiaowenxing.demoproxy.annotation.AccessLimit;
import com.xiaowenxing.demoproxy.annotation.ParamHandle;
import com.xiaowenxing.demoproxy.domin.UserVO;
import com.xiaowenxing.demoproxy.proxy.service.Work;
import org.springframework.stereotype.Service;

/**
 * @author XWX
 * @date 2021/6/4 18:16
 * @since 3.6
 **/
@Service
public class WorkImpl implements Work {


    @Override
    @ParamHandle
    public UserVO doWork() {
        System.out.println("do something");
        UserVO userVO = new UserVO();
        userVO.setUserId(123L);
        userVO.setNickName("test");
        userVO.setAvatar("avatarImpl");
        return userVO;
    }
}
