package com.example.blockhouse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WorkBrokerSendsProofOfWorkTest {
    @Mock
    private BlockchainTransaction blockchainTransaction;
    private BlockchainNode blockchainNode;
    @InjectMocks
    private WorkBroker workBroker;

    @Before
    public void setUp() throws Exception {
        blockchainNode = new BlockchainNode(workBroker);
    }

    @Test
    public void workBrokerShouldSendTaskToNodeWhenReceivingTransaction() {
        blockchainNode.receive(blockchainTransaction);
        assertThat(blockchainNode.hasTask()).isTrue();
    }
}
