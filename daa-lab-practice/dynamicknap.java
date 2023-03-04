import java.util.Scanner;


public class dynamicknap {
    public void solve(int wt[], int []val, int W, int N){
        int i, j;
        int [][]v = new int[N+1][W+1];
        for(i = 0; i <=N; i++){
            for(j = 0; j<=W; j++){
                if(i == 0 || j == 0){
                    v[i][j] = 0;
                }
                else if(wt[i] > j){
                    v[i][j] = v[i-1][j];
                }
                else{
                    v[i][j] = Math.max((v[i-1][j]), (v[i-1][j-wt[i]] + val[i]));
                }
            }
        }
        System.out.println("the optimal solution is: " + v[N][W]);
        int selected[] = new int[N+1];
        for(i = 0; i<N+1; i++){
            selected[i] = 0;
        }
        i = N;
        j = W;
        while(i >0 && j > 0){
            if(v[i][j]!= v[i-1][j]){
                selected[i] = 1;
                j = j-wt[i];
            }
            i--;
        }
        System.out.println("\nthe item selected");
        for(i = 1; i<=N; i++){
            if(selected[i] == 1){
                System.out.println(i + " ");
            }
        }
        System.out.println();
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        dynamicknap ks = new dynamicknap();
        System.out.println("enter the number of the elements: ");
        int n = sc.nextInt();
        int []wt = new int[n+1];
        int []val = new int[n+1];
        System.out.println("enter the weighted graph: ");
        for(int i = 1; i<=n; i++){
            wt[i] = sc.nextInt();
        }
        System.out.println("enter the value of for the elements");
        for(int i = 1; i<=n;i++){
            val[i] = sc.nextInt();
        }
        System.out.println("enter the knapsack weight");
        int w = sc.nextInt();
        ks.solve(wt, val, w, n);
    }
}