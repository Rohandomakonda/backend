package com.example.watchparty.Model;

public class WatchEvent {
    private String partyId;   // Or Long, based on your WatchParty ID
    private String action;    // e.g., "play", "pause", "seek"
    private double timestamp; // current time in seconds

    // Constructors
    public WatchEvent() {}
    public WatchEvent(String partyId, String action, double timestamp) {
        this.partyId = partyId;
        this.action = action;
        this.timestamp = timestamp;
    }

    // Getters & Setters
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }
}

