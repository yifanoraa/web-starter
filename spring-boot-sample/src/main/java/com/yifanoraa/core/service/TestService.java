package com.yifanoraa.core.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.yifanoraa.core.model.TestContent;

public interface TestService {
    int addContent(JSONObject rawContent);

    PageInfo<TestContent> findAllRecords(int pageNum, int pageSize);
}
