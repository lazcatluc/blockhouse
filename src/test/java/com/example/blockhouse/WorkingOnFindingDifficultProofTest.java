package com.example.blockhouse;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WorkingOnFindingDifficultProofTest {
    @InjectMocks
    private BlockchainNode blockchainNode;
    @Mock
    private BlockchainTransaction blockchainTransaction;
    @Mock
    private WorkBroker workBroker;

    @Test
    public void afterReceivingTransactionNodeStartsWorkingOnFindingDifficultProof() {
        blockchainNode.receive(blockchainTransaction);
        verify(workBroker).startWorkingOnBlock(blockchainNode);
    }

}
