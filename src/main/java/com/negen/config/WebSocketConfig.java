package com.negen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ Author     ：Negen
 * @ Date       ：Created in 20:25 2020/3/26
 * @ Description：开启WebSocket
 * @ Modified By：
 * @Version: 1.0
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
