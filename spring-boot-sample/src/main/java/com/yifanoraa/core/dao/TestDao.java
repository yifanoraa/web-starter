package com.yifanoraa.core.dao;


import com.yifanoraa.core.model.TestContent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestDao {

    void insert(TestContent content);

    List<TestContent> fetchContent();

}
