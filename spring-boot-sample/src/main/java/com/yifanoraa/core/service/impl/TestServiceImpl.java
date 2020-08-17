package com.yifanoraa.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yifanoraa.core.dao.TestDao;
import com.yifanoraa.core.model.TestContent;
import com.yifanoraa.core.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "testService")
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;

    @Override
    public int addContent(JSONObject rawContent) {
        testDao.insert(parseRawContent(rawContent));
        return 1;
    }

    @Override
    public PageInfo<TestContent> findAllRecords(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TestContent> userDomains = testDao.fetchContent();
        return new PageInfo(userDomains);
    }

    private TestContent parseRawContent(JSONObject rawContent) {
        TestContent contentModel = new TestContent();
        String content = rawContent.getString("content");
        contentModel.setContent(content);
        return contentModel;

    }
}
