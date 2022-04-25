package com.awei.word.filter.service;


import com.awei.word.filter.domain.QueryModel;
import com.awei.word.filter.domain.WordVo;

import java.util.Map;


public interface IAuthService {

    /**
     *
     * @param key
     * @return
     */
    WordVo forbidWord(QueryModel model);

}