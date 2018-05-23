package com.example.blockhouse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddNewTransactionToNodeBlockTest {

    @InjectMocks
    private BlockchainNode blockchainNode;
    @Mock
    private BlockchainTransaction blockchainTransaction;

    @Test
    public void newTransactionShouldBeAddedToBlockWhenReceived() {
        blockchainNode.receive(blockchainTransaction);
        assertThat(blockchainNode.getBlock().getTransactions()).contains(blockchainTransaction);
    }
}
