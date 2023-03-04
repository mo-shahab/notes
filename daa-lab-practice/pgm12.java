import java.util.Scanner; 
public class pgm12 {
    int n, g[][], x[], i, j, k;
    public pgm12(int n, int g[][]){
        this.n = n;
        this.g  = g;
        this.x = new int[n+1];
        x[1] = 1;
    }
    void hamiltonian(int k) {
        while(true) {
            nextvalue(k);
            if(x[k] == 0){
                return;
            }
            if(k == n){
                System.out.println("the hamiltonian cycles are: ");
                for(int i = 1; i <=n ; i++){
                    System.out.print(x[i]+ "\t");
                }
                System.out.println(1);
            }
            else{
                hamiltonian(k+1);
            }
        }
    }
    void nextvalue(int k ){
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
        int g[][];
        System.out.println("enter the number of the vertices");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        g = new int[n+1][n+1];
        System.out.println("enter the weighted graph matrix");
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                g[i][j] =  sc.nextInt();
            }
        }
        pgm12 l = new pgm12(n, g);
        l.hamiltonian(2);
    }
}