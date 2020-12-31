package com.cc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SearchTreasureBoxTest {

    @Before
    public void setUp() throws Exception {
    }
    @Test
    /**
     * 获取所有宝箱的钥匙
     * 如果: given 数字遍历写在查询里面
     * 当:  when 经过遍历查询后
     * 则:  then 返回一个神秘钥匙数组
     */
    public void searchAllBox(){
        SearchTreasureBox searchTreasureBox = new SearchTreasureBox();
        List<Integer> integers = searchTreasureBox.searchAllBox();
        if (integers.size()>0) {
            integers.stream().forEach(e-> System.out.println(e));
        }
        Assert.assertEquals(10,integers.size());
    }
}