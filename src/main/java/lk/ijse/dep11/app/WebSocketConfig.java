package lk.ijse.dep11.app;

import lk.ijse.dep11.app.wscontroller.ChatWsController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@EnableWebSocket
@Configuration
public class WebSocketConfig  implements WebSocketConfigurer {

    @Bean
    public ChatWsController chatWsController(){
        return new ChatWsController();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatWsController(), "api/v1/messages").setAllowedOrigins("*");
    }
}
