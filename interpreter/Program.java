package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.JumpCode;
import interpreter.bytecode.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Program extends RunTimeStack {
    private int labelIndex;
    private HashMap<String, Integer> CodetoAddress = new HashMap<>();
    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    public void addCode(ByteCode acode){
        program.add(acode);
        if (acode instanceof LabelCode){
            // does the program allowed the know the existence of LabelCode?
            labelIndex = program.size()-2;
            CodetoAddress.put(((LabelCode) acode).getLabel(), labelIndex);
            //System.out.println(((LabelCode) acode).getLabel() + " " + labelIndex);
        }
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }
    public int getsize(){
        return program.size();
    }
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     */
    public void resolveAddrs() {
        for (ByteCode aCode : program){
            if (aCode instanceof JumpCode){
                String label = ((JumpCode) aCode).getLabel();
                //System.out.println(aCode);
                //System.out.println(label);
                ((JumpCode) aCode).setAddy(CodetoAddress.get(label));
                //System.out.println(((JumpCode) aCode).getAddy());
            }
        }

    }




}
