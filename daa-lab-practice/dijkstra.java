import java.util.*;
public class dijkstra {
    public void dijk(int cost [][], int s, int n, int distance[]) {
        int u = 0, i, j, min;
        int visited[] = new int [10];
        for(i = 1; i<=n; i++){
            distance[i] = cost[s][i];
            visited[i] = 0;
        }
        visited[s] = 1;
        for(i = 2; i<=n; i++){
            min = 999;
            for(j = 1; j<=n; j++){
                if(visited[j] == 0 && distance[j]< min){
                    min = distance[j];
                    u =j;
                }
            }
            visited[u] = 1;
            for(j = 1;j<=n;j++){
                if(visited[j] == 0 && distance[u]+cost[u][j] < distance[j]){
                    distance[j] = distance[u] + cost[u][j];
                }
            }
        }
    }
    public static void main(String [] args){
        int cost[][] = new int[10][10];
        int i, j, n, s;
        int distance[] = new int[10];
        System.out.println("enter the number of the vertices: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("enter the matrix");
        for(i = 1; i <=n; i++){
            for(j = 1; j<=n; j++){
                cost[i][j] = sc.nextInt();
            }
        }
        System.out.println("enter the source vertex: ");
        s = sc.nextInt();
        dijkstra t = new dijkstra();
        t.dijk(cost, s, n, distance);
        for(i = 1; i<=n ; i++){
            System.out.println("shortest distance" + s + " ->" + i + " is " + distance[i]);
        }
    }
} 