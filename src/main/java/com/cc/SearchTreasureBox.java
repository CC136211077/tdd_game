package com.cc;

import com.cc.utils.HashUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: CC
 * @date: 2020/12/31 15:33
 * @Description:
 */

public class SearchTreasureBox {

    private List<TreasureBox> treasureBoxes;

    public List<Integer> searchFirst(int secretNum){
        treasureBoxes = new ArrayList<>();
        List<Integer> secretNums = new ArrayList();
        int code = 1;
        TreasureBox treasureBox = TreasureBox.builder().code(code).frontHashValue("0").build();
        String hashValue = treasureBox.getCode() + treasureBox.getFrontHashValue() + secretNum;
        hashValue = HashUtils.getHashValue(hashValue);

        if(hashValue.substring(0,5).equals("00000")){//找到什么钥匙
            System.out.println(hashValue);
            treasureBox.setHashValue(hashValue);
            treasureBox.setSecretNum(secretNum);
            treasureBoxes.add(treasureBox);
            secretNums.add(secretNum);
            code++;
            this.findNextBox(treasureBoxes,code,secretNums);
            return secretNums;
        }
        return secretNums;
    }

    public void findNextBox(List<TreasureBox> treasureBoxes,int code,List<Integer> secretNums){
            if(code<=10){
                for(int i= 1;i<1000000000;i++){
                    TreasureBox treasureBox = TreasureBox.builder().code(code).frontHashValue(treasureBoxes.get(code-2).getHashValue()).build();
                    String hashValue = treasureBox.getCode() + treasureBox.getFrontHashValue() + i;
                    hashValue = HashUtils.getHashValue(hashValue);
                    if(hashValue.substring(0,5).equals("00000")){//找到什么钥匙
                        treasureBox.setHashValue(hashValue);
                        treasureBox.setSecretNum(i);
                        treasureBoxes.add(treasureBox);
                        secretNums.add(i);
                        code++;
                        this.findNextBox(treasureBoxes,code,secretNums);
                        break;
                    }
                }
            }
    }

}