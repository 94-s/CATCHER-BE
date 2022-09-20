package com.project.catcher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
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
        return "deploy test1";
    }
}
