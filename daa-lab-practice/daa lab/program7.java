import java.util.Scanner;
class program7 {
    void dijk(int cost[][], int s, int n, int d[]){
        int i, j, min;
        int u= 0;
        int visited[] = new int[10];
        for(i = 1; i<=n; i++){
            visited[i] = 0;
            d[i] = cost[s][i];
        }
        visited[s] = 1; 
        for(i = 2; i <=n; i++){
            min = 999;
            for(j = 1; j<=n; j++){
                if(visited[j] == 0 && d[j] < min){
                    min = d[j];
                    u = j;
                }
            }
            visited[u] = 1;
            for(j = 1; j<=n; j++){
                if(visited[j] == 0 && d[u]+cost[u][j] < d[j]){
                    d[j] = d[u] + cost[u][j];
                }
            }            
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        program7 t = new program7();
        int n, cost[][], s, d[];
        System.out.println("enter the number of the vertices");
        n = sc.nextInt();
        cost = new int[10][10];
        d = new int[10];
        System.out.println("enter the weighted graph matrix");
        for(int i=1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                cost[i][j] = sc.nextInt();
            }
        }
        System.out.println("enter the source vertex");
        s = sc.nextInt();
        t.dijk(cost, s, n, d);
        System.out.println("the solution is: ");
        for(int i = 1; i<=n; i++){
            System.out.println(s + "--->" + i+ ", " + d[i]);
        }
    }
}