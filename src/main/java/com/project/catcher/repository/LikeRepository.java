package com.project.catcher.repository;

import com.project.catcher.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> findByMemberId(Long memberId);

    List<Like> findByProductId(Long productId);
}
