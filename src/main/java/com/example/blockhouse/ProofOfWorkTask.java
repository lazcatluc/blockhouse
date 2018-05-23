package com.example.blockhouse;

public class ProofOfWorkTask {

    private boolean done;

    public boolean isDone() {
        return done;
    }

    public DifficultProof processWork() throws InterruptedException {
        Thread.sleep(10);
        done = true;
        return null;
    }
}
