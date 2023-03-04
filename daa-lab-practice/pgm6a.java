import java.util.Scanner;

class pgm6a {
    public void solve (int wt[], int p[], int n, int w) {
        int i, j;
        int v[][]= new int[n+1][w+1];
        for(i = 0; i<=n; i++){
            for(j = 0; j<=w; j++){
                if(i == 0 || j == 0){
                    v[i][j] = 0;
                }
                else if(wt[i] > j){
                    v[i][j] = v[i-1][j];
                }
                else{
                    v[i][j] = Math.max((v[i-1][j]), v[i-1][j - wt[i]]+p[i]);
                }
            }
        }
        System.out.println("the optimal solution is: ");
        System.out.println(v[n][w]);
        int selected[] = new int[n+1];
        for(i = 0; i< n+1; i++){
            selected[i] = 0;
        }
        i = n;
        j = w;
        while(i > 0 && j > 0) {
            if(v[i][j] != v[i-1][j]){
                selected[i] = 1;
                j = j - wt[i];
            }
        }
        System.out.println("the items that are added in the knapsack are: ");
        for(i = 0; i< n; i++){
            if(selected[i] == 1){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    public static void main(String [] args) {
        int n, w, p[], wt[];
        System.out.println("enter the number of the items in the knapsack");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        p = new int[n+1];
        wt = new int[n+1];
        System.out.println("enter the maximum weight of the knapsack");
        w = sc.nextInt();
        System.out.println("enter the profits for the knapsack");
        for(int i = 1; i<=n; i++){
            p[i] = sc.nextInt();
        }
        System.out.println("enter the weights of each item");
        for(int i = 1; i<=n; i++){
            wt[i] = sc.nextInt();
        }
        pgm6a k = new pgm6a();
        k.solve(wt, p, n , w);
    }
}