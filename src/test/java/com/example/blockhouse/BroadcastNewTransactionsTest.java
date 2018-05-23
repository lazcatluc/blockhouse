package com.example.blockhouse;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BroadcastNewTransactionsTest {
    @InjectMocks
    private BlockchainNetwork blockchainNetwork;
    @Mock
    private BlockchainTransaction blockchainTransaction;
    @Mock
    private BlockchainNode node;

    @Test
    public void newTransactionsShouldBeBroadcastToAllNodesInANetwork() {
        blockchainNetwork.broadcast(blockchainTransaction);

        blockchainNetwork.getBlockchainNodes().forEach(node ->
            verify(node).receive(blockchainTransaction));
    }

    @Test
    public void newTransactionsShouldBeBroadcastToExistingNodeInANetwork() {
        blockchainNetwork.addNode(node);
        blockchainNetwork.broadcast(blockchainTransaction);

        verify(node).receive(blockchainTransaction);
    }
}
