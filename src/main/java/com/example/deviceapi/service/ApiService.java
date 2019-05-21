package com.example.deviceapi.service;

import com.example.deviceapi.repository.ApiRepository;
import com.example.deviceapi.vo.InsertApiRequest;
import com.example.deviceapi.vo.LogVo;
import com.example.deviceapi.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {

    @Autowired
    private ApiRepository repository;

    public List<UserVo> getUser(UserVo vo) {
        return repository.selectUser(vo);
    }

    public void inserLog(InsertApiRequest req) {
        repository.inserLog(new LogVo(req.getcCcode(), req.getcUno(), req.getcPage()));
    }

}
