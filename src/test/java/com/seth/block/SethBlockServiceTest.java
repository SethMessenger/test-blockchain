package com.seth.block;

import com.alibaba.fastjson.JSON;
import com.seth.formal.blockchain.security.CryptoUtil;
import com.seth.test.blockchain.model.SethBlock;
import com.seth.test.blockchain.model.SethTransaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xunbo.xu
 * @desc    用于测试自行设计的区块链交易流程
 * @date 18/3/12
 */
public class SethBlockServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    /**
     * 实际实现 区块链的初始化和挖矿过程（直接将区块链的创世区块 和 挖矿过程 通过定义随机数nonce的方式进行实现）
     */
    @Test
    public void testBlockChain(){
        //创建一个区块链
        List<SethBlock> blockchain = new ArrayList<SethBlock>();
        //创建创世区块
        SethBlock firstBlock = new SethBlock(1, System.currentTimeMillis(), new ArrayList<SethTransaction>(), 1, "1", "1");

        //创世区块成为区块链中的第一个区块
        blockchain.add(firstBlock);

        //启动交易,发起三个不同的交易
        List<SethTransaction> trans = new ArrayList<SethTransaction>();
        SethTransaction st1 = new SethTransaction();
        SethTransaction st2 = new SethTransaction();
        SethTransaction st3 = new SethTransaction();
        trans.add(st1);
        trans.add(st2);
        trans.add(st3);
        //发币过程，即挖矿，创建一个新交易
        SethTransaction sysTran = new SethTransaction();
        trans.add(sysTran);

        //获取当前区块链的最后一个区块地址
        SethBlock lastBlock = blockchain.get(blockchain.size() - 1);

        String hash = "";
        Integer nonce = 0;
        while (true){
            hash = CryptoUtil.SHA256(lastBlock.getHash() + JSON.toJSONString(trans) + nonce);
            if(hash.startsWith("0000")){
                System.out.println("挖取HASH成功， HASH = " + hash);
                break;
            } else {
                System.out.println("挖取HASH失败， HASH = " + hash);
            }
            nonce++;
        }


    }


    /**
     * 手动实现 区块链的初始化和挖矿过程（直接将区块链的创世区块 和 挖矿过程 写死进行实现）
     */
    @Test
    public void testBlockChainHandle(){

        //创建一个区块链
        List<SethBlock> blockchain = new ArrayList<SethBlock>();
        //创建创世区块
        SethBlock firstBlock = new SethBlock(1, System.currentTimeMillis(), new ArrayList<SethTransaction>(), 1, "1", "1");

        //创世区块成为区块链中的第一个区块
        blockchain.add(firstBlock);

        //启动交易,发起三个不同的交易
        List<SethTransaction> trans = new ArrayList<SethTransaction>();
        SethTransaction st1 = new SethTransaction();
        SethTransaction st2 = new SethTransaction();
        SethTransaction st3 = new SethTransaction();
        trans.add(st1);
        trans.add(st2);
        trans.add(st3);
        //发币过程，即挖矿，创建一个新交易
        SethTransaction sysTran = new SethTransaction();
        trans.add(sysTran);

        //获取当前区块链的最后一个区块地址
        SethBlock lastBlock = blockchain.get(blockchain.size() - 1);

        //计算最细区块链的HASH( SHA256(上一个区块的HASH + 当前区块中所有的交易集合 + 随机数) )
        int nonce = 2;
        String hash = CryptoUtil.SHA256(lastBlock.getHash() + JSON.toJSONString(trans) + nonce);
        SethBlock newBlock = new SethBlock(lastBlock.getIndex()+1, System.currentTimeMillis(), trans, nonce, lastBlock.getHash(), hash);

        //将最新区块加入区块链
        blockchain.add(newBlock);

    }




}
