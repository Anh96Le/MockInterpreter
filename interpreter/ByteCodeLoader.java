
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    //static int z = 1;
    public Program loadCodes() {
        Program apro = new Program();
        ByteCode aBC;
        String className;
        try {
            while (byteSource.ready()) {
                String aCode = byteSource.readLine();
                String[] splitCode = aCode.split(" ");
                //System.out.println(splitCode[0]);
                className = CodeTable.getClassName(splitCode[0]);
                //System.out.println(className);
                Class Bc = Class.forName("interpreter.bytecode." + className);
                aBC = (ByteCode) (Bc.newInstance());
                if (splitCode.length > 1 ){
                    ArrayList<String> toInit = new ArrayList<>();
                    for (int i = 1; i < splitCode.length; i++){
                        if (!(splitCode[i].equals(""))){ // cuz LIT 0    GRATIS-RETURN-VALUE has too many " "
                            toInit.add(splitCode[i]);
                            //System.out.println(splitCode[i]);
                        }
                    }

                    aBC.init(toInit);

                }
                apro.addCode(aBC);


            }
        } catch (Exception e) {
            System.out.println("Anh you messed up.");
            // I'm stuck here, i dont know what exception to throw
        }
        apro.resolveAddrs();
        return apro;
    }
}
