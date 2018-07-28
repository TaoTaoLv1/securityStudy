package com.ywt.com.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;

/**
 * 虚假REST 服务 启动 配置
 */
public class MockServer {

    public static void main(String[] args) {
        //指定 IP 和 端口 （本地就不用指定了）
        WireMock.configureFor(8089);
        //清空以前的配置
        WireMock.removeAllMappings();
        //伪造一个测试桩
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/order")).willReturn(WireMock.aResponse().withBody("{\"id\":1}").withStatus(200)));
    }
}
