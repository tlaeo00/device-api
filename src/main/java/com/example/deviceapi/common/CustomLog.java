package com.example.deviceapi.common;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @class : CustomLog.java
 * @since : 2019-07-29.
 * @author : 심대진, 고잉컴
 * Description : 특정 로깅 컨버팅
 * TODO : Pattern.matches, StringBuilder 사용해서 리팩토링
 */
public class CustomLog extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        String parsingMsg = "device_id"; // 파싱 문자열
        String replaceMsg = "device_id = '...'"; // replace 문자열
        
        String msg = iLoggingEvent.getMessage();
        msg = msg.replaceAll("(" + parsingMsg + " = '[\\d\\w\\S]*')", replaceMsg);
        msg = msg.replaceAll("(" + parsingMsg + " ='[\\d\\w\\S]*')", replaceMsg);
        msg = msg.replaceAll("(" + parsingMsg + "= '[\\d\\w\\S]*')", replaceMsg);
        msg = msg.replaceAll("(" + parsingMsg + "='[\\d\\w\\S]*')", replaceMsg);
        return msg;
    }
}