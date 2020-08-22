package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;


    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();

        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);

    }
    public int sizeofRTS(){
        return runTimeStack.size();
    }
    public int currentFrame(){
        return framePointer.peek();
    }
    public void dump(){
        String toDump = "[";
        Iterator<Integer> framePtIter = framePointer.iterator();
        int bottom = framePtIter.next();
        while(framePtIter.hasNext()){
            int top = framePtIter.next();
            for(int i = bottom; i< top; i++){
                toDump+=runTimeStack.get(i);
                if(i!=top-1){
                    toDump += ",";
                }

            }
            toDump+="][";
            bottom = top;
        }
        for(int i = bottom; i<runTimeStack.size(); i++){
            toDump+=runTimeStack.get(i);
            if(i!=runTimeStack.size()-1){
                toDump += ",";
            }
        }
        toDump+="]";
        System.out.println(toDump);

    }
    public int peek(){
        return runTimeStack.get(runTimeStack.size()-1);

    }
    public int push(int i){
        runTimeStack.add(i);
        return i;
    }
    public int pop(){
        return runTimeStack.remove(runTimeStack.size()-1);
    }
    public int store(int offset){
        //remember to calculate offset in bytecode;
        int temp = runTimeStack.remove(runTimeStack.size()-1);

        runTimeStack.set(offset, temp);
        return temp;
    }
    public int load(int offset){
        //remember to calculate offset in ByteCode
        int temp = runTimeStack.get(offset);
        runTimeStack.add(temp);
        return temp;
    }
    public void newFrameAt(int offset){
        //rememeber to calculate offset
        framePointer.push(offset);
    }

    public void popFrame() {
        framePointer.pop();
    }
}
