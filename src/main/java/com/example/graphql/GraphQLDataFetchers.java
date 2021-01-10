package com.example.graphql.baseballdetails;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private static List<Team> teams = Arrays.asList(
        new Team("1", "Yankees", Arrays.asList("1","2")),
        new Team("2", "Rays", Arrays.asList("3","4"))
    );

    private static List<Map<String, String>> players = Arrays.asList(
            ImmutableMap.of("id", "1",
                    "firstName", "Aaron",
                    "lastName", "Judge",
                    "position", "RF",
                    "number", "99"),
            ImmutableMap.of("id", "2",
                    "firstName", "Gleyber",
                    "lastName", "Torres",
                    "position", "SS",
                    "number", "25"),
            ImmutableMap.of("id", "3",
                    "firstName", "Randy",
                    "lastName", "Arozarena",
                    "position", "CF",
                    "number", "56"),
            ImmutableMap.of("id", "4",
                    "firstName", "Ji-man",
                    "lastName", "Choi",
                    "position", "1B",
                    "number", "26")
    );

    public DataFetcher getTeamByNameDataFetcher() {
        return dataFetchingEnvironment -> {
            String teamName = dataFetchingEnvironment.getArgument("name");
            return teams
                    .stream()
                    .filter(team -> team.getName().equals(teamName))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getPlayersDataFetcher() {
        return dataFetchingEnvironment -> {
            Team team = dataFetchingEnvironment.getSource();
            List<String> playerList = team.getPlayers();
            ArrayList<Map<String, String>> retList = new ArrayList<Map<String, String>>();
            for (String player : playerList) {
                Map<String, String> foundPlayer = players
                                                .stream()
                                                .filter(p -> p.get("id").equals(player))
                                                .findFirst()
                                                .orElse(null);
                System.out.println(foundPlayer);
                retList.add(foundPlayer);
            };
            return retList;
        };
    }
}