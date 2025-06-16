package com.example.watchparty.Controller;

import com.example.watchparty.Model.WatchEvent;
import com.example.watchparty.Model.WatchParty;
import com.example.watchparty.Service.WatchPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WatchPartyWebSocketController {

    @Autowired
    private WatchPartyService service;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/participants/{inviteCode}")
    public void broadcastParticipants(@DestinationVariable String inviteCode) {
        WatchParty party = service.getWatchParty(inviteCode.trim()).orElse(null);
        if (party != null) {
            messagingTemplate.convertAndSend(
                    "/topic/participants/" + inviteCode,
                    party.getParticipantIds()
            );
        }
    }

    @MessageMapping("/sync/{partyCode}")
    @SendTo("/topic/updates/{partyCode}")
    public WatchEvent handleAction(@DestinationVariable String partyCode, WatchEvent event) {
        return event;
    }

}
