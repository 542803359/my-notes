package com.xiaowenxing.utils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * 腾讯授权工具类
 *
 * @author xiaowx
 * @date 2021/11/29 11:24
 **/
@Slf4j
public class TencentAuthUtil {

    /**
     * https://developers.weixin.qq.com/doc/oplatform/Website_App/WeChat_Login/Authorized_Interface_Calling_UnionID.html
     * <p>
     * wx根据code获取access_token等信息
     * <p>
     */
    private static final String WX_TOKEN_BY_CODE = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    /**
     * wx根据access_token等获取用户基本信息
     */
    private static final String WX_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s";


    /**
     * qq获取用户基本信息
     */
    private static final String QQ_USER_INFO = "https://graph.qq.com/user/get_user_info?access_token=%s&oauth_consumer_key=%s&openid=%s";

    /**
     * 通过code获取access_token
     *
     * @param code:      授权码
     * @param appId:     应用唯一标识，在微信开放平台提交应用审核通过后获得
     * @param appSecret: 应用密钥AppSecret，在微信开放平台提交应用审核通过后获得
     * @return JSONObject
     */
    public static JSONObject getWxAccessTokenByCode(String code, String appId, String appSecret) {

        String url = String.format(WX_TOKEN_BY_CODE, appId, appSecret, code);
        String result = HttpUtil.get(url, 5000);
        log.info("根据wx_code获取access_token信息 url:{},result:{}", url, result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (result == null || ObjectUtil.isNotNull(jsonObject.getString("errcode"))) {
            throw new RuntimeException("微信授权失败");
        }
        if (StrUtil.isBlank(jsonObject.getString("openid"))) {
            throw new RuntimeException("微信授权失败");
        }
        return jsonObject;
    }

    /**
     * 获取微信用户基本信息
     *
     * @param accessToken: 调用接口凭证
     * @param openid:      普通用户标识
     * @return JSONObject
     */
    public static JSONObject getWxUserInfo(String accessToken, String openid) {
        String url = String.format(WX_USER_INFO, accessToken, openid);
        String result = HttpUtil.get(url, 5000);
        log.info("获取微信用户基本信息 url:{},result:{}", url, result);
        return JSONObject.parseObject(result);
    }


    /**
     * 获取QQ用户基本信息
     *
     * @param accessToken: 调用接口凭证
     * @param appId:       分配给应用的appid
     * @param openid:      普通用户标识
     * @return JSONObject
     */
    public static JSONObject getQqUserInfo(String accessToken, String appId, String openid) {
        String url = String.format(QQ_USER_INFO, accessToken, appId, openid);
        String result = HttpUtil.get(url, 5000);
        log.info("获取QQ用户基本信息 url:{},result:{}", url, result);
        return JSONObject.parseObject(result);
    }
}
