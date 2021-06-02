package com.hzwtech.cjwjs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/30
 * @since v1.0
 */
@Slf4j
@RestController
@RequestMapping("/logging")
public class LogController {
    @GetMapping("/do")
    public String log() {
        log.info("log4j2 test date: {}  info: {}", LocalDate.now(), "请关注hzwtech.com");
        return "log4j2";
    }
}