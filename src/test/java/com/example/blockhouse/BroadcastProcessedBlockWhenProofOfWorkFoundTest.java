package com.example.blockhouse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BroadcastProcessedBlockWhenProofOfWorkFoundTest {

    private BlockchainNode blockchainNode;
    @Mock
    private WorkBroker workBroker;
    @Mock
    private ProofOfWorkTask proofOfWorkTask;
    @Mock
    private BlockchainTransaction blockchainTransaction;

    @Before
    public void setUp() throws Exception {
        blockchainNode = spy(new BlockchainNode(workBroker));
    }

    @Test
    public void nodeShouldBroadcastBlockWhenItHasFinishedFindingProof() throws InterruptedException {
        when(workBroker.startWorkingOnBlock(any())).thenReturn(proofOfWorkTask);
        blockchainNode.receive(blockchainTransaction);
        Thread.sleep(100);

        verify(blockchainNode).broadcast(any());
    }
}
