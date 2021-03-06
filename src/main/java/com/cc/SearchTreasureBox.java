package com.cc;

import com.cc.utils.HashUtils;
import com.cc.utils.NumConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CC
 * @date: 2020/12/31 15:33
 * @Description: 搜索宝箱
 */

public class SearchTreasureBox {

    private List<TreasureBox> treasureBoxes;

    /**
     * 查询第一个宝箱
     * @param secretNum
     * @return
     */
    public List<Integer> searchFirst(int secretNum){
        treasureBoxes = new ArrayList<>();
        List<Integer> secretNums = new ArrayList();
        int code = NumConstant.ONE;
        TreasureBox treasureBox = TreasureBox.builder().code(code).frontHashValue(NumConstant.ZERO+"").build();
        String hashValue = treasureBox.getCode() + treasureBox.getFrontHashValue() + secretNum;
        hashValue = HashUtils.getHashValue(hashValue);

        if(hashValue.substring(NumConstant.ONE,NumConstant.FIVE).equals("00000")){//找到什么钥匙
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

    /**
     * 搜索所有的宝箱的神秘数字
     * @return
     */
    public List<Integer> searchAllBox(){
        treasureBoxes = new ArrayList<>();
        List<Integer> secretNums = new ArrayList();
        int code = NumConstant.ONE;
        this.findNextBox(treasureBoxes,code,secretNums);
        return secretNums;
    }

    /**
     * 寻找下一个宝箱
     * @param treasureBoxes 所有的宝箱
     * @param code 宝箱编号
     * @param secretNums 神秘密码
     */
    public void findNextBox(List<TreasureBox> treasureBoxes,int code,List<Integer> secretNums){
            if(code<=NumConstant.TEN){
                for(int i= 1;i<1000000000;i++){
                    TreasureBox treasureBox = TreasureBox.builder().code(code).build();
                    if(code==1){
                        treasureBox.setFrontHashValue("0");
                    }else {
                        treasureBox.setFrontHashValue(treasureBoxes.get(code-2).getHashValue());
                    }
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
