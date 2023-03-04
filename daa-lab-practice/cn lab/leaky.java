import java.util.*;
public class leaky {
    static int min(int x, int y){
        if(x > y){
            return y;
        }
        else{
            return x;
        }
    }
    public static void main(String [] args){
        int drop = 0, nsec, mini, cap, count = 0, i, process;
        int [] inp = new int[25];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the bucket size");
        cap = sc.nextInt();
        System.out.println("enter the operation rate");
        process = sc.nextInt();
        System.out.println("enter the seconds you want to simulate");
        nsec = sc.nextInt();
        for(i = 0; i < nsec; i++){
            System.out.println("enter the size of the packet entering at " + i + " sec");
            inp[i] = sc.nextInt();
        }
        System.out.println("\nSecond | Packet Received | Packet Sent |Packet Left | Packet Dropped|\n");
        for(i = 0; i< nsec; i++){
            count = count + inp[i];
            if(count > cap){
                drop = count - cap;
                count = cap;
            }
            System.out.print(i+1);
            System.out.print("\t\t" + inp[i]);
            mini = min(count, process);
            System.out.print("\t\t" + mini);
            count = count - mini;
            System.out.print("\t\t" + count);
            System.out.print("\t\t" + drop);
            drop = 0;
            System.out.println();
        }
        for(i = nsec; count!=0; i++){
            
            if(count > cap){
                drop = count - cap;
                count = cap;
            }
            System.out.print(i+1);
            System.out.print("\t\t" + inp[i]);
            mini = min(count, process);
            System.out.print("\t\t" + mini);
            count = count - mini;
            System.out.print("\t\t" + count);
            System.out.print("\t\t" + drop);
            drop = 0;
            System.out.println();
        }
    }
}