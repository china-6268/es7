package com.hzwtech.cjwjs.util.result;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/6/2
 * @since v1.0
 */

@Getter
@Setter
@Table(name = "LOGGER")
public class LoggerEntity {
    @Id
    @KeySql(genId = UUIdGenId.class)
    @Column(name = "LOGGER_ID")
    private String loggerId;
}
