package com.example.watchparty.Controller;

import com.example.watchparty.Model.WatchParty;
import com.example.watchparty.Service.WatchPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/watch-party")
@CrossOrigin(
        origins = "http://127.0.0.1:5500"
)
public class WatchPartyController {

    @Autowired
    private WatchPartyService service;

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
    public Optional<WatchParty> joinParty(@RequestParam String inviteCode, @RequestParam Long userId) {
        return service.joinWatchParty(inviteCode, userId);
    }

    @GetMapping("/get")
    public ResponseEntity<WatchParty> getParty(@RequestParam String inviteCode) {
        String trimmedCode = inviteCode.trim();
        Optional<WatchParty> party = service.getWatchParty(trimmedCode);

        return party.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }

}
