package com.example.watchparty.Repository;

import com.example.watchparty.Model.WatchParty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WatchPartyRepository extends JpaRepository<WatchParty, Long> {
    Optional<WatchParty> findByInviteCode(String inviteCode);
}