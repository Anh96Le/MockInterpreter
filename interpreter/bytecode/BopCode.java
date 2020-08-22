package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    String Oprator;
    @Override
    public void executeCode(VirtualMachine virtualMachine){
        int secondOperand = virtualMachine.popVM();
        int firstOperand = virtualMachine.popVM();
        int result = 0;
        switch (Oprator){
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = firstOperand / secondOperand;
                break;
            case "==":
                if (firstOperand == secondOperand){result =1;}
                break;
            case "!=":
                if (firstOperand != secondOperand){result =1;}
                break;
            case ">=":
                if (firstOperand >= secondOperand){result =1;}
                break;
            case "<=":
                if (firstOperand <= secondOperand){result =1;}
                break;
            case ">":
                if (firstOperand > secondOperand){result =1;}
                break;
            case "<":
                if (firstOperand < secondOperand){result =1;}
                break;
            case "|":
                if ((firstOperand!=0) || (secondOperand!=0)){result =1;}
                break;
            case "&":
                if ((firstOperand!=0) && (secondOperand!=0)){result =1;}
                break;
        }
        virtualMachine.pushVM(result);
    }
    @Override
    public void init(ArrayList<String> args){
        Oprator = args.get(0);
    }
    @Override
    public String toString(){
        return "BOP "+Oprator;
    }
}
