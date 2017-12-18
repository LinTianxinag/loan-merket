package com.fuhui.service.impl;

import com.alibaba.fastjson.JSON;
import com.fuhui.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * package name:com.fuhui.service.impl
 *
 * @author:panwang
 * @description: ${todo}(用一句话描述该文件做什么)
 * @date:2017/11/27
 * @version:V1.0
 * @see:jdk8 Copyright (c) 2017, mikuismywifu@gmail.com All Rights Reserved.
 */
@Service
@CacheConfig(cacheNames = "testService")
public class TestServiceImpl implements TestService {



}
