package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    private String label;
    public String getLabel(){
        return this.label;
    }

    @Override
    public void executeCode(VirtualMachine virtualMachine){
    }
    @Override
    public void init(ArrayList<String> args){
        label = args.get(0);
    }
    @Override
    public String toString(){
        return "LABEL " + label;
    }

}
