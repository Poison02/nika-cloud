package com.zch.sse;

import lombok.Getter;
import lombok.Setter;

/**
 * 通用SSE参数
 * @author Zch
 * @date 2023/8/5
 **/
@Getter
@Setter
public class CommonSseParam {

    private String clientId;

    private String loginId;
}
