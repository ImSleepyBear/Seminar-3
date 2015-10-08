//This class represents a user process that access memory
//In the constructor set the filename that should be used to 
//generate memory addresses

package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jof
 */
public class MemoryProcess {
    private String fileName;
    private MemoryManager mm;
    
    public MemoryProcess(String filename,MemoryManager mmu){
        fileName=filename;
        mm=mmu;
    }   
    
     public void callMemory(){
        try {
            //start to open file
            Scanner reader=new Scanner(new File(fileName));
            int address;
            int nbrOfIterations=0;
            //repeat as long as there are still memory references
            while(reader.hasNextInt()){
                nbrOfIterations++;
                //read memory address to access
                address=reader.nextInt();
                //System.out.println(address);
                //read content from memory
                mm.read(address);
            }
            System.out.println("Iterations: "+ nbrOfIterations);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MemoryProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
