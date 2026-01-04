package com.community.group.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.group.Repository.ObservationRepository;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final ObservationRepository repo;

    public DashboardController(ObservationRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{authority}/summary")
    public Map<String, Object> summary(@PathVariable String authority) {
        Map<String, Object> response = new HashMap<>();
        response.put("totalObservations", repo.countByAuthority(authority));
        response.put("recentObservations", repo.findTop5ByAuthorityOrderByCreatedAtDesc(authority));
        response.put("leaderboard", repo.topContributors(authority, PageRequest.of(0, 3)));
        return response;
    }
}
