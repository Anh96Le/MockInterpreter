package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    private int variable;
    @Override
    public void executeCode(VirtualMachine virtualMachine){
        //have to check stack for pop
        for(int i = 0; i <variable;i++){
            if(virtualMachine.sizeofRTS()>0){
                virtualMachine.popVM();
            }
        }
    }
    @Override
    public void init(ArrayList<String> args){
        variable = Integer.parseInt(args.get(0));
    }

    @Override
    public String toString() {
        return "POP " + this.variable;
    }
}
