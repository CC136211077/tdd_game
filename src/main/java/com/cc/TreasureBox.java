package com.cc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: CC
 * @date: 2020/12/31 14:44
 * @Description: 宝箱
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TreasureBox {
    /**
     * 宝箱编号
     */
    private int code;
    /**
     * 时间戳
     */
    private Long date;
    /**
     * Hash值
     */
    private String hashValue;
    /**
     * 上一宝箱Hash值
     */
    private String frontHashValue;
    /**
     * 神秘数字
     */
    private int secretNum;
}
