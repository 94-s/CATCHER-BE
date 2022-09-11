package com.project.catcher.service;

import com.project.catcher.entity.LatestSearchHistory;
import com.project.catcher.repository.LatestSearchHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LatestSearchHistoryService {

    private final LatestSearchHistoryRepository latestSearchHistoryRepository;

    public List<LatestSearchHistory> getLatestSearchHistories(Long memberId) {
        return latestSearchHistoryRepository.findAllByMemberId(memberId);
    }
}
