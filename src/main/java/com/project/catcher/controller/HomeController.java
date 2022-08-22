package com.project.catcher.controller;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
public class HomeController {

    @Autowired
    EntityManager em;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @GetMapping("/")
    @Transactional
    public String index(){
//
////        Member member = new Member();
////        member.setEmail("asdasd1asd");
////        member.setNickname("asdasasd1d");
////        member.setSocialLoginType(SocialType.KAKAO);
////
////        member.setImgUrl("aasds1d");
////        member.setIsDelete(true);
////        member.setCreatedBy(111L);
////        em.persist(member);
////
////        Member member1 = em.find(Member.class, member.getId());
//
//        List<Member> fetch = jpaQueryFactory.selectFrom(QMember.member).fetch();
        return "test";
    }
}
