package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private String label = "";
    @Override
    public void executeCode(VirtualMachine virtualMachine){
        int temp = virtualMachine.popVM();
        for(int i =0; i<virtualMachine.sizeofRTS()-virtualMachine.currentframeis();i++){
            virtualMachine.popVM();
        }
        virtualMachine.popFrame();
        virtualMachine.pushVM(temp);
        virtualMachine.gotoAddy(virtualMachine.getreturnAddy());
    }
    @Override
    public void init(ArrayList<String> args){
        label = args.get(0);
    }
    @Override
    public String toString(){
        return "RETURN "+ label;
    }
}
