package com.cc;

import com.cc.utils.HashUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchTreasureBoxTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
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

    }
}