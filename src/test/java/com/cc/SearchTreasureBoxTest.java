package com.cc;

import com.cc.utils.HashUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchTreasureBoxTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    /**
     * 已知晓第一个钥匙查询所有
     * 如果: given 数字遍历写在查询里面
     * 当:  when 经过遍历查询后
     * 则:  then 返回一个神秘钥匙数组
     */
    public void searchFirst() {
        SearchTreasureBox searchTreasureBox = new SearchTreasureBox();
//        for(int i=1;i<1000000000;i++){
//
//            String s = searchTreasureBox.searchFirst(i);
//            System.out.println(s);
//            if(s.equals("00000")){
//                System.out.println(i);
//                break;
//            }
//        }
        List<Integer> integers = searchTreasureBox.searchFirst(3229170);
        integers.stream().forEach(e-> System.out.println(e));
        if (integers.size()>0) {
            integers.stream().forEach(e-> System.out.println(e));
        }
        Assert.assertEquals(10,integers.size());
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