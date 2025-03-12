package org.example.commandInterface;

public interface State {
    public void excute();
    public State nextState();    
}