package com.example.deviceapi.service;

import com.example.deviceapi.repository.ApiRepository;
import com.example.deviceapi.vo.InsertApiRequest;
import com.example.deviceapi.vo.LogVo;
import com.example.deviceapi.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApiService {

    @Autowired
    private ApiRepository repository;

    public List<UserVo> getUser(UserVo vo) {
        return repository.selectUser(vo);
    }

    public void insertLog(InsertApiRequest req) {
        repository.inserLog(new LogVo(req.getcCcode(), req.getcUno(), req.getcPage()));
        // 강제 익셉션
        if(true) throw new RuntimeException("1건은 등록됨. 익셉션 발생 했지만 Rollback 되지 않음");
        repository.inserLog(new LogVo(req.getcCcode(), req.getcUno(), req.getcPage()));
    }

    /**
     * 선언적 Transaction 설정(트랜잭션 필요한 Method 에 적용하면됨)
     * propagation, rollbackFor, Isolation 등등 여러 속성들이 있다. (필요시 사용하면됨)
     * @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, RuntimeException.class}, isolation = Isolation.DEFAULT)
     * @param req
     */
    @Transactional
    public void insertLogTransactional(InsertApiRequest req) {
        repository.inserLog(new LogVo(req.getcCcode(), req.getcUno(), req.getcPage()));
        // 강제 익셉션
        if(true) throw new RuntimeException("1건에 대해 Rollback 처리됨");
        repository.inserLog(new LogVo(req.getcCcode(), req.getcUno(), req.getcPage()));
    }

}
