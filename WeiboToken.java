package com.tencent.weibo.sdk.android.component.sso;

import java.io.Serializable;

/**
 * 令牌
 * 
 * @author isaacxie
 * 
 */
public class WeiboToken implements Serializable {
    private static final long serialVersionUID = -5720575747471590393L;

    public WeiboToken() {
    }

    public WeiboToken(String accessToken, long expiresIn, String refreshToken, String openID, String omasToken, String omasKey) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.openID = openID;
        this.omasToken = omasToken;
        this.omasKey = omasKey;
    }

    /** AccessToken */
	public String accessToken;

	/** AccessToken过期时间 */
	public long expiresIn;

	/** 用来换新的AccessToken */
	public String refreshToken;

	/** 兼容OpenID协议 */
	public String openID;

	/** OmasToken */
	public String omasToken;

	/** omasKey */
	public String omasKey;

}
