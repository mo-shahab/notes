import java.util.Scanner;
public class Hamiltoniancycle {
    int n, g[][], x[], i, j, k;
    public Hamiltoniancycle(int n, int [][]g){
        this.n = n;
        this.g = g;
        this.x = new int[n+1];
        x[1] = 1;
    }
    public void hamiltonian(int k) {
        while(true) {
            nextvalue(k);
            if(x[k] == 0) {
                return;
            }
            if(k == n) {
                System.out.println("solution: ");
                for(int i = 1; i<=n; i++){
                    System.out.println(x[i] + "\t");
                }
                System.out.println(1);
            }
            else {
                hamiltonian(k+1);
            }
        }
    }
    public void nextvalue(int k) {
        while(true){
            x[k] = (x[k]+1) % (n+1);
            if(x[k] == 0) {
                return;
            }
            if(g[x[k-1]][x[k]] != 0){
                for(j = 1; j<=k; j++){
                    if(x[j] == x[k]){
                        break;
                    }
                }
                if(j == k){
                    if((k < n) || ((k == n) && g[x[n]][x[1]] != 0)){
                        return;
                    }
                }
            }
        }
    }
    public static void main(String [] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of the vertices: ");
        n = sc.nextInt();
        int [][] g = new int[n+1][n+1];
        System.out.println("enter the matrix: ");
        for(int i = 1; i <=n; i++){
            for(int j = 1; j<=n; j++){
                g[i][j] = sc.nextInt();
            }
        }
        Hamiltoniancycle ham = new Hamiltoniancycle(n, g);
        ham.hamiltonian(2);
    }
}
