package com.seth.model;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc    自定义区块
 * @date 18/3/12
 */
public class SethBlockChain {

    /** 区块索引 **/
    private Integer index;
    /** 区块随机数 **/
    private Integer nonce;
    /** 交易集合 **/
    private List<SethTransaction> txs;
    /** 区块唯一标志HASH **/
    private String hash;


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getNonce() {
        return nonce;
    }

    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }

    public List<SethTransaction> getTxs() {
        return txs;
    }

    public void setTxs(List<SethTransaction> txs) {
        this.txs = txs;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
