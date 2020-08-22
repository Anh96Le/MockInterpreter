package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {
    @Override
    public void executeCode(VirtualMachine virtualMachine){
        virtualMachine.stopExecution();
    }
    @Override
    public void init(ArrayList<String> args){
    }
    @Override
    public String toString(){return "HALT";}
}
