package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int offset;
    @Override
    public void executeCode(VirtualMachine virtualMachine){
        int currentframe = virtualMachine.currentframeis();
        int offsetat = currentframe + offset;
        virtualMachine.storeVM(offsetat);
    }
    @Override
    public void init(ArrayList<String> args){
        offset = Integer.parseInt(args.get(0));
    }
    @Override
    public String toString(){
        return "STORE "+offset;
    }
}
