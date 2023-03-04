import java.util.Scanner;

class program6a {
    void solve(int n, int w, int p[], int wt[]){
        int i, j;
        int v[][] = new int[n+1][w+1];
        for(i = 0; i<=n; i++){
            for(j = 0; j<=w; j++){
                if(i == 0 || j == 0){
                    v[i][j] = 0;
                }
                else if(wt[i] > j ){
                    v[i][j] = v[i-1][j];
                }
                else {
                    v[i][j] = Math.max(v[i-1][j], v[i-1][j-wt[i]] + p[i]);
                }
            }
        }
        System.out.println("the optimal solution is: " + v[n][w]);
        int selected[] = new int[n+1];
        
        for(i = 1; i<=n; i++){
            selected[i] = 0;
        }
        i = n;
        j = w;
        while(i >  0 && j > 0){
            if(v[i][j] != v[i-1][j]){
                selected[i] = 1;
                j = j - wt[i];
            }
            i--;
        } 
        System.out.println("the items added are:");
        for(i = 1; i<=n; i++){
            if(selected[i] == 1){
                System.out.println(i);
            }
        }
        System.out.println();
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n, w;
        System.out.println("enter the number of the elements");
        n = sc.nextInt();
        int wt[] = new int[n+1];
        int p[] = new int[n+1];
        System.out.println("enter the weights of the each objects");
        for(int i = 1; i<=n; i++){
            wt[i] = sc.nextInt();
        }
        System.out.println("enter the values of the each objects");
        for(int i = 1; i<=n; i++){
            p[i] = sc.nextInt();
        }
        System.out.println("enter the max capacity of the knapsack");
        w = sc.nextInt();
        program6a k = new program6a();
        k.solve(n, w, p, wt);
    }
}