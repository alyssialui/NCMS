/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.util.*;
/**
 *
 * @author Kris
 */
public class main{
    
    static Scanner scan = new Scanner(System.in);
    
    public static void main (String args[]){
        
        System.out.println("Executed read manifests");
        try{
            CRUD_Manifest.read();
        }
        catch (Exception e){
            System.out.println("Error");
        }
        String ans = scan.next();
    }
}
