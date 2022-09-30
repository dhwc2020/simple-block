package com.dhwc.pojo.bo;

import com.dhwc.util.StringUtils;

import java.util.Date;

/**
 * 区块对象模型
 * @author dhwc
 * @create 2022-09-30 15:43
 */
public class BlockBO {
    //上一个区块的hash码
    private String preHash;
    //本区块的hash码
    private String hash;
    //内容
    private String data;
    //产生区块的时间戳
    private Long timestamp;
    //最小修改次数
    private Integer nonce;

    public String getPreHash() {
        return preHash;
    }

    public String getHash() {
        return hash;
    }

    public String getData() {
        return data;
    }

    public BlockBO(String preHash, String data) {
        this.preHash = preHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.nonce = 0;
        this.hash = calculateHash();
    }

    public String calculateHash(){
        return StringUtils.applySha256(preHash + timestamp + nonce  + data);
    }

    public void mineBlock(int difficulty){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < difficulty; i++) {
            sb.append('0');
        }
        String mode = sb.toString();

        while(!hash.substring(0, difficulty).equals(mode)){
            nonce++;
            hash = calculateHash();
        }
    }
}
