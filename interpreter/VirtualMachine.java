package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runStack;
    private Stack<Integer> returnAddrs;
    private Program        program;
    private int            pc;
    private boolean        isRunning;

    protected VirtualMachine(Program program) {
        this.program = program;
    }
    private boolean isDumping = true;

    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
   /*    for(int i = 0; i < program.getsize();i++){
           System.out.println(i + "vm" + program.getCode(i));
        }*/
        while (isRunning){
            ByteCode code = program.getCode(pc);
            code.executeCode(this);
//            System.out.println(code);
            pc++;
            if(isDumping==true){
                System.out.println(code);
                runStack.dump();
            }
        }
    }
    public int peekVM(){
        return runStack.peek();
    }
    public void storeVM(int offset){
        runStack.store(offset);
    }
    public void popFrame(){
        runStack.popFrame();
    }
    public int loadVM(int offset){
        return runStack.load(offset);
    }
    public int currentframeis(){
        return runStack.currentFrame();
    }
    public void newFrame(int offset){
        runStack.newFrameAt(offset);
    }
    public int sizeofRTS(){
        return runStack.sizeofRTS();
    }
    public int saveReturnAddy(){
        return returnAddrs.push(pc);
    }
    public int getreturnAddy(){
        return returnAddrs.pop();
    }
    public void gotoAddy(int addy){
        pc = addy;
    }
    public int popVM(){
        return runStack.pop();
    }
    public void pushVM(int value){
        runStack.push(value);
    }
    public void stopExecution(){
        isRunning = false;
    }
    public void turnDump(boolean turnonoff){
        if (turnonoff==true){
            isDumping=true;
        }
        else if (turnonoff ==false){
            isDumping=false;
        }
    }
}
