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

    /**
     * 数据库写入
     * @param rawContent JSON参数
     * @return
     */
    @Override
    public int addContent(JSONObject rawContent) {
        testDao.insert(parseRawContent(rawContent));
        return 1;
    }

    /**
     * 数据库分页读取
     * @param pageNum 分页数
     * @param pageSize 分页大小
     * @return
     */
    @Override
    public PageInfo findAllRecords(int pageNum, int pageSize) {
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
