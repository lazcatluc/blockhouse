package com.example.blockhouse;

public class BlockchainNode {
    private final WorkBroker workBroker;
    private final BlockchainBlock block = new BlockchainBlock();

    public BlockchainNode(WorkBroker workBroker) {
        this.workBroker = workBroker;
    }

    public void receive(BlockchainTransaction blockchainTransaction) {
        block.addNewTransaction(blockchainTransaction);
        workBroker.startWorkingOnBlock(this);
    }

    public BlockchainBlock getBlock() {
        return block;
    }

}
