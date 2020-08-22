package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    private int variable;
    @Override
    public void executeCode(VirtualMachine virtualMachine){
        int topRTS = virtualMachine.sizeofRTS();
        virtualMachine.newFrame(topRTS-variable);
    }
    @Override
    public void init(ArrayList<String> args){
        variable = Integer.parseInt(args.get(0));
    }
    @Override
    public String toString(){
        return "ARGS " + variable;
    }
}
