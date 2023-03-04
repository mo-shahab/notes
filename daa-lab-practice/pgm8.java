import java.util.Scanner;

public class pgm8 {
    int p[] = new int[10];
    int find(int i){
        while(p[i] >= 0){
            i = p[i];
        }
        return i;
    }
    void kruskal(int cost[][], int n){
        int i, j, k, min, mcost = 0;
        int ne;
        int u = 0, v = 0;
        int t[][] = new int[10][3];
        for(i = 1; i<=n; i++){
            p[i] = -1;
        }
        ne = 0;
        while(ne < n-1){
            min = 999;
            for(i = 1; i<=n; i++){
                for(j = i+1; j<=n; j++){
                    if(cost[i][j]<min){
                        min = cost[i][j];
                        u = i;
                        v = j;
                    }
                }
            }
            if(min == 999){
                break;
            }
            j = find(u);
            k = find(v);
            if(j != k){
                ne++;
                t[ne][1] = u;
                t[ne][2] = v;
                mcost = mcost + cost[u][v];
                p[k] = j;
            }
            cost[u][v] = cost[v][u] = 999;
        }
        if(ne != n-1){
            System.out.println("no spanning tree");
        }
        else{
            System.out.println("the spanning tree is ");
            for(k = 1; k<=n-1; k++){
                System.out.println(t[k][1] + ", " + t[k][2]);
            }
            System.out.println("the minimum cost is " + mcost);
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of the vertices in the graph");
        int n = sc.nextInt();
        System.out.println("enter the weighted graph matrix");
        int cost[][] = new int[10][10];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                cost[i][j] = sc.nextInt();
            }
        }
        pgm8 k = new pgm8();
        k.kruskal(cost, n);
    }
}