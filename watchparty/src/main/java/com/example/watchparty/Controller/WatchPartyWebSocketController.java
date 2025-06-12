package com.example.watchparty.Controller;

import com.example.watchparty.Model.WatchEvent;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class WatchPartyWebSocketController {

    @MessageMapping("/sync")  // incoming from frontend
    @SendTo("/topic/updates")  // outgoing to all clients
    public WatchEvent handleAction(WatchEvent event) {
        return event;  // broadcast it back to /topic/updates
    }
}


