package interpreter.bytecode;
import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ByteCode {
   private static HashMap<String, ByteCode> byteCodeMap = new HashMap<>();

    public abstract void executeCode(VirtualMachine virtualMachine);
    public abstract void init(ArrayList<String> args);
}
