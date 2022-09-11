package com.project.catcher.service;

import com.project.catcher.entity.Like;
import com.project.catcher.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    public List<Like> getLikesByMemberId(Long memberId) {
        return likeRepository.findByMemberId(memberId);
    }

    public List<Like> getLikesByProductId(Long productId) {
        return likeRepository.findByProductId(productId);
    }

    public Like saveLike(Like like) {
        return likeRepository.save(like);
    }

    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }
}
