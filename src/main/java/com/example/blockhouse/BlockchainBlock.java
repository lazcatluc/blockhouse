package com.example.blockhouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockchainBlock {

    private final List<BlockchainTransaction> blockchainTransactions = new ArrayList<>();

    public List<BlockchainTransaction> getTransactions() {
        return Collections.unmodifiableList(blockchainTransactions);
    }

    public void addNewTransaction(BlockchainTransaction blockchainTransaction) {
        blockchainTransactions.add(blockchainTransaction);
    }
}
