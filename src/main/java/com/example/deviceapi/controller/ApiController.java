package com.example.deviceapi.controller;

import com.example.deviceapi.service.ApiService;
import com.example.deviceapi.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private ApiService service;

    /**
     * Get 방식 @RequestParam 으로 받기
     * 예시 : http://localhost:9000/getUserGet/v1?userNo=12
     * 예시 : http://localhost:9000/getUserGet/v1?userNo=
     * @param userNo
     * @return
     */
    @RequestMapping(value="/getUserGet/v1", method = RequestMethod.GET)
    public UserVo getUserGetV1(@RequestParam String userNo) {
        log.info("userNo : {}", userNo);
        if(StringUtils.isBlank(userNo)) throw new RuntimeException("userNo 가 없습니다.");
        return service.getUser(new UserVo(userNo)).stream().findFirst().orElseGet(() -> new UserVo());
    }

    /**
     * Get 방식 @ModelAttribute 으로 받기
     * http://localhost:9000/getUserGet/v2?userNo=12
     * http://localhost:9000/getUserGet/v2?userNo=
     * @param req
     * @return
     */
    @RequestMapping(value="/getUserGet/v2", method = RequestMethod.GET)
    public UserVo getUserGetV2(@Validated @ModelAttribute GetUserGetRequest req) { // @Validated 로 GetUserGetRequest 안에 파라미터를 필터링함
        log.info("GetUserGetRequest : {}", ToStringBuilder.reflectionToString(req, ToStringStyle.MULTI_LINE_STYLE)); // 로그 출력 예쁘게.... SIMPLE_STYLE 도 많이 씀
        return service.getUser(new UserVo(req.getUserNo())).stream().findFirst().orElseGet(() -> new UserVo());
    }

    /**
     * Post 방식 @RequestBody 으로 받기
     * http://localhost:9000/getUserPost/v1   {"userNo":"12"}
     * http://localhost:9000/getUserPost/v1   {"userNo":""}
     * @param req
     * @return
     */
    @RequestMapping(value="/getUserPost/v1", method = RequestMethod.POST)
    public GetUserPostResponse getUserPost(@Validated @RequestBody GetUserPostRequest req) { // @Validated 로 GetUserPostRequest 안에 파라미터를 필터링함
        log.info("GetUserPostRequest : {}", ToStringBuilder.reflectionToString(req, ToStringStyle.MULTI_LINE_STYLE)); // 로그 출력 예쁘게.... SIMPLE_STYLE 도 많이 씀
        return new GetUserPostResponse(service.getUser(new UserVo(req.getUserNo()))); // 응답결과 userList 안에 넣기
    }

    /**
     * Get, Post 방식 둘다 받기
     * http://localhost:9000/all/v1
     * @return
     */
    @RequestMapping(value="/all/v1", method = {RequestMethod.GET, RequestMethod.POST})
    public GetUserPostResponse all() {
        return new GetUserPostResponse(service.getUser(null)); // 응답결과 userList 안에 넣기
    }

    @RequestMapping(value="/insertApi/v1", method = {RequestMethod.POST})
    public InsertApiRsponse insertApi(@RequestBody InsertApiRequest req) {
        service.inserLog(req);
        return new InsertApiRsponse(); // 응답결과 userList 안에 넣기
    }

}
