package com.example.deviceapi.repository;

import com.example.deviceapi.vo.LogVo;
import com.example.deviceapi.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApiRepository {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private final static String NAMESPACE = "ApiMapper";

    /**
     * User 목록 조회
     * @param vo
     * @return
     */
    public List<UserVo> selectUser(UserVo vo) {
        return sqlSessionTemplate.selectList(StringUtils.join(NAMESPACE, ".", "selectUser"), vo);
    }

    public void inserLog(LogVo vo) {
        sqlSessionTemplate.insert(StringUtils.join(NAMESPACE, ".", "insertLog"), vo);
    }

}
