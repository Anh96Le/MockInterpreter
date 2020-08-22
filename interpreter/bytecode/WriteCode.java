package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {
    @Override
    public void executeCode(VirtualMachine virtualMachine){
        System.out.println(virtualMachine.peekVM());
    }
    @Override
    public void init(ArrayList<String> args){
    }
    @Override
    public String toString(){
        return "WRITE ";
    }
}
