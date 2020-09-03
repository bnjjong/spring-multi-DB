/*
 * COPYRIGHT (c) ADOP 2020
 * This software is the proprietary of ADOP
 *
 * @author <a href=“mailto:jordan@adop.cc“>jordan</a>
 * @since 2020/09/03
 */
package org.jjong.demo.web;

import lombok.RequiredArgsConstructor;
import org.jjong.demo.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * create on 2020/09/03.
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author jordan
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
@RestController
@RequiredArgsConstructor
public class SimpleController {
    @Autowired
    private SimpleService service;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/mainDB")
    public String dbMainTest() {
        try {
            service.mainDBTest();
            return "200";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/secondDB")
    public String dbSecondTest() {
        try {
            service.secondDBTest();
            return "200";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "error";
        }
    }

}
