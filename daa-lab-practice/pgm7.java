import java.util.Scanner;

public class pgm7 {
    public void dijk(int cost[][], int s, int n, int d[]){
        int i, j, u = 0;
        int visited[] = new int[10];
        for(i = 1; i<=n; i++){
            d[i] = cost[s][i];
            visited[i] = 0;
        }
        visited[s] = 0;
        int min;
        for(i = 2; i<=n; i++){
            min = 999;
            for(j = 1; j <=n; j++){
                if(visited[j] == 0 && d[j] < min){
                    min = d[j];
                    u = j;
                }                
            }
            visited[u] = 1;
            for(j = 1; j<= n; j++){
                if(visited[j] == 0 && d[j] > d[u] + cost[u][j]) {
                    d[j] = d[u] + cost[u][j];
                }
            }
        }
    }
    public static void main(String []args){
        int cost[][];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of the vertices ");
        int n = sc.nextInt();
        cost = new int[10][10];
        System.out.println("enter the weighted matrix");
        for(int i = 1; i <=n; i++){
            for(int j = 1; j<=n; j++){
                cost[i][j] = sc.nextInt();
            }
        }
        System.out.println("enter the source vertex: ");
        int s = sc.nextInt();
        int d[] = new int[10];
        pgm7 t = new pgm7();
        t.dijk(cost, s, n, d);
        System.out.println("the solution is ");
        for(int i = 1; i <=n; i++){
            System.out.println(s + "--->" + i +" is "+ d[i]);
        }
    }
}
