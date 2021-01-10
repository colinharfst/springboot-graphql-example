package com.example.graphql.baseballdetails;

import java.util.List;

public class Team {
    private String id;
    private String name;
    private List<String> players;

    public Team(String id, String name, List<String> players) {
        this.id = id;
        this.name = name;
        this.players = players;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getPlayers() {
        return this.players;
    }
}