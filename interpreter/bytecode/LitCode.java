package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    int variable;
    private String value="";
    @Override
    public void executeCode(VirtualMachine virtualMachine){
        virtualMachine.pushVM(variable);
    }
    @Override
    public void init(ArrayList<String> args){
            variable=Integer.parseInt(args.get(0));
            if(args.size()>1){
            value = args.get(1);}
    }
    @Override
    public String toString(){
        return "LIT "+ variable + " " +value;
    }
}
