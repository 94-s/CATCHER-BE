package com.project.catcher.controller;

import com.project.catcher.entity.Member;
import com.project.catcher.entity.enums.SocialType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
public class HomeController {

    @Autowired
    EntityManager em;

    @GetMapping("/")
    @Transactional
    public Member index(){

        Member member = new Member();
        member.setEmail("asdasd1asd");
        member.setNickname("asdasasd1d");
        member.setSocialLoginType(SocialType.KAKAO);

        member.setImgUrl("aasds1d");
        member.setIsDelete(true);
        member.setCreatedBy(111L);
        em.persist(member);

        Member member1 = em.find(Member.class, member.getId());

        return member1;
    }
}
