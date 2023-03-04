import java.util.*;
public class bell{
    private int d[];
    private int num_ver;
    public static final int max_value = 999;
    public bell(int num_ver){
        this.num_ver = num_ver;
        d = new int[num_ver + 1];
    }
    public void bellmanfordevaluation(int source, int a[][]){
        for(int node = 1; node <= num_ver; node++){
            d[node] = max_value;
        }
        d[source] = 0;
        for(int node = 1; node<=num_ver-1; node++){
            for(int sn = 1; sn <=num_ver; sn++){
                for(int dn = 1; dn < =num_ver; dn++){
                    
                }
            }
        }
    }
}