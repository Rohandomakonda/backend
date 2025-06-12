package com.example.watchparty.Service;

import com.example.watchparty.Model.WatchParty;
import com.example.watchparty.Repository.WatchPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class WatchPartyService {

    @Autowired
    private WatchPartyRepository repository;

    public WatchParty createWatchParty(Long hostId, String videoId) {
        WatchParty party = new WatchParty();
        party.setHostId(hostId);
        party.setVideoId(videoId);
        party.setCreatedAt(LocalDateTime.now());
        party.setInviteCode(UUID.randomUUID().toString().substring(0, 6)); // <-- generate here
        party.setParticipantIds(new ArrayList<>(List.of(hostId)));

        WatchParty saved = repository.save(party);
        System.out.println("Created Party with Invite Code: " + saved.getInviteCode()); // Log it
        return saved;
    }


    public Optional<WatchParty> joinWatchParty(String inviteCode, Long userId) {
        Optional<WatchParty> optParty = repository.findByInviteCode(inviteCode);
        optParty.ifPresent(party -> {
            if (!party.getParticipantIds().contains(userId)) {
                party.getParticipantIds().add(userId);
                repository.save(party);
            }
        });
        return optParty;
    }

    public Optional<WatchParty> getWatchParty(String inviteCode) {
        return repository.findByInviteCode(inviteCode.trim());
    }

    public boolean isHost(Long partyId, Long userId) {
        return repository.findById(partyId)
                .map(p -> p.getHostId().equals(userId))
                .orElse(false);
    }
}