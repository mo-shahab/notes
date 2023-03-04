import java.io.*;
import java.math.*;
import java.util.*;
public class rsa {
    static BigInteger phi, n, e, d, x, y;
    static BigInteger m, c;
    static BigInteger p, q, s;
    public static void main(String [] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter two relative prime numbers: ");
        System.out.println("enter p:");
        p = sc.nextBigInteger();
        System.out.println("enter q: ");
        q = sc.nextBigInteger();
        n = p.multiply(q);
        System.out.println("n = p*q" + n);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println("phi = " + phi);
        System.out.println("enter e");
        e = sc.nextBigInteger();
        d = e.modInverse(phi);
        System.out.println("d = " + d);
        System.out.println("public key e = " + e);
        System.out.println("private key d: " + d);
        System.out.println("enter something in the plain text: ");
        m = sc.nextBigInteger();
        x = encrypt(m);
        System.out.println("the encrypted message is : " + x);
        System.out.println("enter the cipher text ");
        c = sc.nextBigInteger();
        y = decrypt(c);
        System.out.println("the decrypted message is " + y);
    }
    public static BigInteger encrypt(BigInteger M){
        return M.modPow(e, n);
    }
    public static BigInteger decrypt(BigInteger C){
        return C.modPow(d, n);
    }
}
