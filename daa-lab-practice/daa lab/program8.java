import java.util.Scanner;

class program8 {
    int p[] = new int[10];
    int find(int i){
        while(p[i] > 0){
            i = p[i];
        }
        return i;
    }
    void krkl(int cost[][], int n){
        int i, j, k, u = 0, v = 0, ne, min, mcost = 0;
        int t[][] = new int[10][3];
        for(i = 1; i<=n; i++){
            p[i] = -1;
        }
        ne = 0;
        while(ne < n-1){
            min = 999;
            for(i = 1; i<=n; i++){
                for(j = i+1; j<=n; j++){
                    if(cost[i][j] < min){
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
        else
        {
            System.out.println("the spanning tree");
            for(k = 1; k<=n; k++){
                System.out.println(t[k][1] + ", " + t[k][2]);
            }
            System.out.println("the min cost is : " + mcost);
        }
    }
    public static void main(String [] args){
        int cost [][] = new int [10][10];
        int i, j;
        System.out.println("enter the no of the vertices");
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        System.out.println("enter the weigted graph");
        for(i = 1; i<=n; i++) {
            for(j = 1; j<=n; j++){
                cost[i][j] = sc.nextInt();
            }
        }
        program8 k = new program8();
        k.krkl(cost, n);
        sc.close();
    }
}