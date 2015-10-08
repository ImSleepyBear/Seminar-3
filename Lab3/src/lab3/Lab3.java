/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author jof
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //create a Memory manager
        //256 pages
        //page size 256
        //256 frames in physical memory
        //page file located in BACKING_STORE.bin
        MemoryManager mmu=new MemoryManager(256,256,256,"BACKING_STORE.bin");
        //create a MemoryProcess
        //this object simulates memory access of a process
        //the virtual addresses to read from are specified in addresses.txt
        MemoryProcess mp=new MemoryProcess("addresses.txt",mmu);
        //simulate memory access
        mp.callMemory();
        //print number of page faults
        System.out.println("Page faults: "+mmu.getNbrOfPagefaults());
    }
    
}
