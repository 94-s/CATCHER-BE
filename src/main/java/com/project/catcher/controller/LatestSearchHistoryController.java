package com.project.catcher.controller;

import com.project.catcher.entity.LatestSearchHistory;
import com.project.catcher.service.LatestSearchHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LatestSearchHistoryController {

    private final LatestSearchHistoryService latestSearchHistoryService;

    @GetMapping("/{id}")
    public List<LatestSearchHistory> getLatestSearchHistory(@PathVariable("id") Long memberId) {
        return latestSearchHistoryService.getLatestSearchHistories(memberId);
    }
}
