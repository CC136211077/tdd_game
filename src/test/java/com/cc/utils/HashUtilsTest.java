package com.cc.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试HashUtils工具类
 */
public class HashUtilsTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    /**
     * 测试HashUtils生成是否成功
     * 如果: given 准备一个字符串
     * 当:  when 经过处理后
     * 则:  then 返回一个Hash值
     */
    public void getHashValue() {
        String str = "123414124";
        String hashValue = HashUtils.getHashValue(str);
        System.out.println(hashValue);
        Assert.assertEquals(StringUtils.isNoneBlank(hashValue),true);
    }
}