package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    Scanner input = new Scanner(System.in);
    @Override
    public void executeCode(VirtualMachine virtualMachine){
        System.out.println("Please input a number: ");
        while (true){
            String userIn = input.next();
            if (isNumeric(userIn)){
                virtualMachine.pushVM(Integer.parseInt(userIn));
                break;
            }
            else {System.out.println("Please input an INTEGER PLEASE: ");}

        }
    }
    @Override
    public void init(ArrayList<String> args){
    }
    @Override
    public String toString(){
        return "READ ";
    }
    public static boolean isNumeric(String strNum) {
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
