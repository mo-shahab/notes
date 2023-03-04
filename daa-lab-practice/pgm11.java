import java.util.Scanner;
import java.lang.Math;

public class pgm11 {
    void subset(int num, int n, int x[]){
        int i;
        for(i = 1; i<=n; i++){
            x[i] = num%2;
            num = num/2;
        }
    }
    public static void main(String [] args){
        int a[] = new int[10];
        int x[] = new int[10];
        int n, d, sum, present = 0;
        System.out.println("enter the number of elements in the set");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("enter the elements in the set");
        for(int i = 1; i<=n ;i++){
            a[i] = sc.nextInt();
        }
        System.out.println("enter the positive sum of the integer");
        d = sc.nextInt();
        if(d > 0){
            for(int i = 1; i< Math.pow(2, n) - 1; i++){
                pgm11 s = new pgm11();
                s.subset(i, n, x);
                sum = 0;
                for(int j = 1; j<=n; j++){
                    if(x[j] == 1){
                        sum = sum + a[j];
                    }
                }
                if(sum == d){
                    System.out.println("the subset is: ");
                    present = 1;
                    for(int j = 1; j <=n; j++){
                        if(x[j] == 1){
                            System.out.print(a[j] + " ");
                        }
                    }
                    System.out.println();
                }
            }
            if(present == 0){
                System.out.println("the soulution does not exist");
            }
        }
    }
}
