import java.util.Scanner;

class gknapsack {
    int n;
    int m; 
    int p[];
    int  wt[];
    gknapsack (int n, int m, int p[], int wt[]){
        this.n = n;
        this.m = m;
        this.p = p;
        this.wt = wt;
    }
    void solve(){
        int i;
        double x[] = new double[n];
        for(i = 0; i<n ;i++){
            x[i] = 0.0;
        }
        double rc = m;
        for(i = 0; i < n; i++){
            if(wt[i] > rc){
                break;
            }
            x[i] = 1;
            rc = rc - wt[i];
        }
        if(i <= n){
            x[i] = rc/wt[i];
        }
        double netprofit = 0.0;
        for(i = 0; i< n; i++){
            if(x[i] > 0.0){
                netprofit = netprofit + x[i]*p[i];
            }
        }
        System.out.println("the netprofit is " + netprofit);
        System.out.println("the items added in the knapsack are: ");
        for(i = 0; i< n ; i++){
            System.out.println(x[i]);
        }
    }
}

public class pgm6b {
    public static void main(String [] args){
        System.out.println("enter the number of elements in the knapsack: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int wt[] = new int[n];
        int p[] = new int[n];
        System.out.println("enter the maximum capacity of the knapsack: ");
        int m = sc.nextInt();
        System.out.println("enter the weights of each item");
        for(int i = 0; i< n; i++){
            wt[i] = sc.nextInt();
        }
        System.out.println("enter the profits from each item: ");
        for(int i = 0; i< n ; i++){
            p[i] = sc.nextInt();
        }
        gknapsack k = new gknapsack(n, m, p, wt);
        k.solve();
    }    
}