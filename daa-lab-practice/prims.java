import java.util.Scanner;

public class prims {
    public static void main(String[] args) {
        int[][] cost = new int[10][10];
        int[][] t = new int[10][3];
        int[] nr = new int[10];
        int n, i, j, k = 0, l = 0;
        int min = 999;
        int mcost = 0;
        System.out.println("Enter no. of vertices: ");
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        System.out.println("Enter Weighted graph: ");
        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++)
                cost[i][j] = scan.nextInt();

        for (i = 1; i <= n; i++)
            for (j = i + 1; j <= n; j++)
                if (cost[i][j] < min) {
                    min = cost[i][j];
                    k = i;
                    l = j;
                }
        t[1][1] = k;
        t[1][2] = l;
        mcost = cost[k][l];
        for (i = 1; i <= n; i++)
            if (cost[i][l] < cost[i][k])
                nr[i] = l;
            else
                nr[i] = k;
        nr[k] = nr[l] = 0;
        for (i = 2; i <= n - 1; i++) {
            min = 999;
            j = 0;
            for (k = 1; k <= n; k++)
                if ((nr[k] != 0) && (cost[k][nr[k]] < min)) {
                    min = cost[k][nr[k]];
                    j = k;
                }
            t[i][1] = j;
            t[i][2] = nr[j];
            mcost = mcost + cost[j][nr[j]];
            nr[j] = 0;
            for (k = 1; k <= n; k++)
                if ((nr[k] != 0) && (cost[k][nr[k]] > cost[k][j]))
                    nr[k] = j;

        }
        if (mcost > 999)
            System.out.println("NO Spanning Tree\n");
        else {
            System.out.println("Spanning Tree\n");
            for (k = 1; k < n; k++)

                System.out.println(t[k][1] + ", " + t[k][2] + "--> " + cost[t[k][1]][t[k][2]]);
            System.out.println("mincost = " + mcost);
        }
    }
}