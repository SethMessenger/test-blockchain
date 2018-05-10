package com.seth.test.blockchain.model;

import java.util.List;

/**
 * @author xunbo.xu
 * @desc    自定义区块
 * @date 18/3/12
 */
public class SethBlock {

    /** 区块索引 **/
    private Integer index;
    /** 区块随机数 **/
    private Integer nonce;
    /** 交易集合 **/
    private List<SethTransaction> transactions;
    /** 区块唯一标志HASH **/
    private String hash;
    /** 区块创建时间戳 **/
    private Long timestamp;
    /** 前一个区块的HASH, SHA256(上一个区块的HASH + 当前区块中所有的交易集合 + 随机数) **/
    private String previousHash;

    public SethBlock() {
        super();
    }

    public SethBlock(int index, long timestamp, List<SethTransaction> transactions, int nonce, String previousHash, String hash) {
        super();
        this.index = index;
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.nonce = nonce;
        this.previousHash = previousHash;
        this.hash = hash;
    }


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

    public List<SethTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<SethTransaction> transactions) {
        this.transactions = transactions;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }
}
