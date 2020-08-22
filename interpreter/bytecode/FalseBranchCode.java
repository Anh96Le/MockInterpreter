package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends JumpCode {
    private int AddresstoJump;
    private String Label;
    @Override
    public void executeCode(VirtualMachine virtualMachine){
        int isFalse = virtualMachine.popVM();
        if (isFalse == 0) {
            virtualMachine.gotoAddy(this.getAddy());
        }
    }
    @Override
    public void init(ArrayList<String> args){
        Label = args.get(0);
    }
    public void setAddy(int addy){
        this.AddresstoJump = addy;
    }
    @Override
    public int getAddy(){
        return AddresstoJump;
    }
    public String getLabel(){
        return Label;
    }
    @Override
    public String toString(){
        return "FALSEBRANCH " + Label;
    }
}
