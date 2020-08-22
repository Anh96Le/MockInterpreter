package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public abstract class JumpCode extends ByteCode {

    @Override
    public void executeCode(VirtualMachine virtualMachine){
    }
    @Override
    public void init(ArrayList<String> args){
    }

    public void setAddy(int x){
    }
    public abstract int getAddy();
    public String getLabel(){
        return null;
    }
}
