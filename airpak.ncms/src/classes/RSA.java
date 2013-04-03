/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Matthew
 */
import java.math.BigInteger;  
import java.util.Random;   
  
public class RSA {  
      
    private BigInteger p;  
    private BigInteger q;  
    private BigInteger N;  
    private BigInteger phi;  
    private BigInteger e;  
    private BigInteger d;  
    private int bitlength = 1024;  
    private int blocksize = 256; //blocksize in byte  
      
    private Random r;  
     public RSA() {  
        r = new Random();  
        p = BigInteger.probablePrime(bitlength, r);  
        q = BigInteger.probablePrime(bitlength, r);  
          N = p.multiply(q);  
            
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));  
          e = BigInteger.probablePrime(bitlength/2, r);  
          
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0 ) {  
            e.add(BigInteger.ONE);  
        }  
        d = e.modInverse(phi);   
    }  
      
    public RSA(BigInteger e, BigInteger d, BigInteger N) {  
        this.e = e;  
        this.d = d;  
        this.N = N;  
    }  
    
     public byte[] encrypt(byte[] message) {       
        return (new BigInteger(message)).modPow(e, N).toByteArray();  
    }  
    
    public BigInteger getE(){
        return e;
    }
    
    public BigInteger getN(){
        return N;
    }
    public byte[] decrypt(byte[] message) {  
        return (new BigInteger(message)).modPow(d, N).toByteArray();  
    }  
}