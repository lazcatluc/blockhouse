package com.example.blockhouse;

public class BlockchainNode {
    private final BlockchainBlock block = new BlockchainBlock();

    public void receive(BlockchainTransaction blockchainTransaction) {
        block.addNewTransaction(blockchainTransaction);
    }

    public BlockchainBlock getBlock() {
        return block;
    }
}
