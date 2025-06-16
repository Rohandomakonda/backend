package com.example.watchparty.Controller;

import com.example.watchparty.Model.WatchParty;
import com.example.watchparty.Service.WatchPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/watch-party")
public class WatchPartyController {

    @Autowired
    private WatchPartyService service;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/create")
    public ResponseEntity<WatchParty> createParty(@RequestParam Long hostId, @RequestParam String videoId) {
        WatchParty party = service.createWatchParty(hostId, videoId);
        return ResponseEntity.ok(party);
    }

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("Watch Party API is up");
    }

    @PostMapping("/join")
    public ResponseEntity<WatchParty> joinParty(@RequestParam String inviteCode, @RequestParam Long userId) {
        Optional<WatchParty> partyOpt = service.joinWatchParty(inviteCode.trim(), userId);

        if (partyOpt.isPresent()) {
            WatchParty party = partyOpt.get();

            // ✅ Broadcast updated participants to only this party
            messagingTemplate.convertAndSend(
                    "/topic/participants/" + inviteCode.trim(),
                    party.getParticipantIds()
            );

            return ResponseEntity.ok(party);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<WatchParty> getParty(@RequestParam String inviteCode) {
        Optional<WatchParty> party = service.getWatchParty(inviteCode.trim());

        return party.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }
}
