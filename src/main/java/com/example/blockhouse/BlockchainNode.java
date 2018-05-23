package com.example.blockhouse;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BlockchainNode {
    private final WorkBroker workBroker;
    private final BlockchainBlock block = new BlockchainBlock();
    private ProofOfWorkTask proofOfWorkTask;

    public BlockchainNode(WorkBroker workBroker) {
        this.workBroker = workBroker;
    }

    public void receive(BlockchainTransaction blockchainTransaction) {
        block.addNewTransaction(blockchainTransaction);
        proofOfWorkTask = workBroker.startWorkingOnBlock(this);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try {
                proofOfWorkTask.processWork();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            broadcast(block);
        });
    }


    public BlockchainBlock getBlock() {
        return block;
    }

    public boolean hasTask() {
        return proofOfWorkTask != null;
    }

    public void broadcast(BlockchainBlock block) {

    }
}
