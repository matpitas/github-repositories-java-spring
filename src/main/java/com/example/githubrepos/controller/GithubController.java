package com.example.githubrepos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.githubrepos.client.GithubClient;

@RestController
@RequestMapping("/v1")
public class GithubController {

    
    private GithubClient githubClient;

    public GithubController(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @GetMapping("/repos")
    public ResponseEntity<List<RepositoryResponse>> listRespo(@RequestHeader("token") String token) {

        var repos = githubClient.listRepos("Bearer "+token, null, "public");

        return ResponseEntity.ok(repos);
    }
}
