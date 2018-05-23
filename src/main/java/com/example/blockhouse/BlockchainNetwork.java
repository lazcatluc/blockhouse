package com.example.blockhouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockchainNetwork {
    private final List<BlockchainNode> blockchainNodes = new ArrayList<>();

    public void broadcast(BlockchainTransaction blockchainTransaction) {
        blockchainNodes.forEach(node -> node.receive(blockchainTransaction));
    }

    public List<BlockchainNode> getBlockchainNodes() {
        return Collections.unmodifiableList(blockchainNodes);
    }

    public void addNode(BlockchainNode node) {
        blockchainNodes.add(node);
    }
}
