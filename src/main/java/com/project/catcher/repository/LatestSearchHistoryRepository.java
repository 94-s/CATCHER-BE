package com.project.catcher.repository;

import com.project.catcher.entity.LatestSearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LatestSearchHistoryRepository extends JpaRepository<LatestSearchHistory, Long> {

    List<LatestSearchHistory> findAllByMemberId(Long memberId);
}

