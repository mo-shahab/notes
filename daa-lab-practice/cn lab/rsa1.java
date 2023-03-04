import java.io.*;
import java.math.BigInteger;
import java.net.*;
import java.util.*;
public class rsa1 {
    static BigInteger n, phi, x, y, e, d;
    static BigInteger m, c;
    static BigInteger p, q, s;
    public static void main(String [] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter two relatively prime numbers");
        System.out.println("enter p: ");
        p = sc.nextBigInteger();
        System.out.println("enter q: ");
        q = sc.nextBigInteger();
        n = p.multiply(q);
        System.out.println("n = p*q: " + n );
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println("enter e: ");
        e = sc.nextBigInteger();
        d = e.modInverse(phi);
        System.out.println("the public key is: " + e);
        System.out.println("the private key is: " + d);
        System.out.println("enter plain text: ");
        m = sc.nextBigInteger();
        x = encrypt(m);
        System.out.println("the encrypted message is " + x);
        System.out.println("enter the cipher text");
        c = sc.nextBigInteger();
        y = decrypt(c);
        System.out.println("the  decrypted message is: " + y);
    }
    static BigInteger encrypt(BigInteger m){
        return m.modPow(e, n);
    }
    static BigInteger decrypt(BigInteger c){
        return c.modPow(d, n);
    }
}