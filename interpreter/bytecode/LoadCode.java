package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    int offset;
    @Override
    public void executeCode(VirtualMachine virtualMachine){
        int currentFrame = virtualMachine.currentframeis();
        int temp = virtualMachine.loadVM(currentFrame+offset);
    }
    @Override
    public void init(ArrayList<String> args){
        offset = Integer.parseInt(args.get(0));
    }
    @Override
    public String toString(){
        return "LOAD "+offset;
    }
}
