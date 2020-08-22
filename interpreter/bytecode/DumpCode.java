package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    boolean dumpornah;
    String label;
    @Override
    public void executeCode(VirtualMachine virtualMachine){

            virtualMachine.turnDump(dumpornah);

    }
    @Override
    public void init(ArrayList<String> args){
        if(args.get(0).toLowerCase().equals("on")){
            dumpornah = true;
            label = "ON";
        }
        else if (args.get(0).toLowerCase().equals("off")){
            dumpornah = false;
            label = "OFF";
        }
    }
    @Override
    public String toString(){
        return "DUMP "+ label;
    }
}
