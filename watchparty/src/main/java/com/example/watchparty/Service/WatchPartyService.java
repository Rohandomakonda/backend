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
        String trimmedCode = inviteCode.trim();
        System.out.println("Attempting to join party with code: " + trimmedCode);

        Optional<WatchParty> optParty = repository.findByInviteCode(trimmedCode);

        if (optParty.isPresent()) {
            WatchParty party = optParty.get();
            if (!party.getParticipantIds().contains(userId)) {
                party.getParticipantIds().add(userId);
                WatchParty saved = repository.save(party);
                System.out.println("User " + userId + " joined party: " + trimmedCode);
                return Optional.of(saved);
            } else {
                System.out.println("User " + userId + " already in party: " + trimmedCode);
                return optParty; // User already in party
            }
        } else {
            System.out.println("Party not found with code: " + trimmedCode);
            return Optional.empty();
        }
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