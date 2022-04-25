package com.awei.word.filter.service.impl;

import com.alibaba.fastjson.JSON;
import com.awei.word.filter.common.ACAutomaton;
import com.awei.word.filter.common.SensitiveInfo;
import com.awei.word.filter.common.WordFilterUtil;
import com.awei.word.filter.domain.QueryModel;
import com.awei.word.filter.domain.WordVo;
import com.awei.word.filter.service.IAuthService;
import com.google.common.base.Joiner;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthServiceImpl implements IAuthService {

    @Override
    public WordVo forbidWord(QueryModel model) {
        if (model == null) {

        }
        String word = model.getWord();
        List<ACAutomaton.Match> list = WordFilterUtil.getGoldenEyes().findSensitive(word);
        List<String> forbidWordList = new ArrayList<String>();
        for (Iterator<ACAutomaton.Match> iter = list.iterator(); iter.hasNext(); ) {
            ACAutomaton.Match match = iter.next();
            SensitiveInfo info = (SensitiveInfo) match.info;
            forbidWordList.add(info.getTerm());
        }
        WordVo wordVo = new WordVo();
        wordVo.setWord(word);
        wordVo.setForbidWord(forbidWordList);
        wordVo.setCheckStatus(forbidWordList.size() > 0 ? false : true);
        wordVo.setMessage(forbidWordList.size() > 0 ? "注意! 验证文本中含有敏感词!" : "ok! 验证文本无敏感词!");
        if (forbidWordList != null && forbidWordList.size() > 0) {
            for (String w : forbidWordList) {
                System.out.println(Joiner.on("|").join(word, w));
            }
        }
        System.out.println(JSON.toJSONString(wordVo));
        return wordVo;
    }
}
