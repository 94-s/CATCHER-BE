package com.project.catcher.controller;


import com.project.catcher.entity.AccuseType;
import com.project.catcher.service.AccuseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accuse-type")
@RequiredArgsConstructor
public class AccuseController {

    private final AccuseService accuseService;

    // REST
    // 조회
    // GET
    //   /accuse-type/{id}
//    @GetMapping("/{id}")
//    public AccuseType getAccuseType(@PathVariable("id") Long accuseTypeId){
//        return accuseService.getAccuseType(accuseTypeId);
//    }

    // Accuse Type 생성
    // POST
    //  /accuse-type


    // Accuse Type 수정
    // PATCH
    // /accuse-type/{id}


    // Accuse Type 삭제
    // DELETE
    // /accuse-type/{id}


    // 목록 조회
    // GET
    // /accuse-type
}
