package com.example.githubrepos.client;

import java.util.List;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import com.example.githubrepos.controller.RepositoryResponse;

public interface GithubClient {

    @GetExchange("/user/repos")
    public List<RepositoryResponse> listRepos(
        @RequestHeader("Authorization") String token, 
        @RequestHeader(value = "X-GitHub-Api-Version", defaultValue = "2022-11-28") String apiVersion,
        @RequestParam("visibility") String visibility
    );
}
