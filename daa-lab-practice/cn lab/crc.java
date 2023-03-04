import java.io.*;
public class crc{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] data;
        int [] divisor;
        int [] crc;
        int [] div;
        int [] rem;
        int data_bits, divisor_bits, tot_length;
        System.out.println("enter the number of data bits:");
        data_bits = Integer.parseInt(br.readLine());
        System.out.println("enter the data bits");
        data = new int[data_bits];
        for(int i = 0; i< data_bits; i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("enter the number of the bits in the divisor");
        divisor_bits = Integer.parseInt(br.readLine());
        divisor = new int[divisor_bits];
        System.out.println("enter the divisor bits");
        for(int i = 0; i< divisor_bits; i++){
            divisor[i] = Integer.parseInt(br.readLine());
        }
        tot_length = data_bits + divisor_bits-1;
        div = new int[tot_length];
        rem = new int[tot_length]; 
        crc = new int[tot_length];

        // crc generation
        for(int i = 0; i< data.length; i++){
            div[i] = data[i];
        }
        System.out.println("dividend(after appending 0s) are: ");
        for(int i = 0; i< div.length; i++){
            System.out.print(div[i]);
        }
        rem = divide(div, divisor, rem);
        for(int i = 0; i<div.length; i++){
            crc[i] = (div[i]^rem[i]);
        }
        System.out.println();
        System.out.println("crc code: ");
        for(int i = 0; i<crc.length; i++){
            System.out.println(crc[i]);
        }
        System.out.println();
        System.out.println("enter crc code of " + tot_length + "bits: ");
        for(int i = 0; i<crc.length; i++){
            crc[i] = Integer.parseInt(br.readLine());
        }
        for(int j = 0; j<crc.length; j++){
            rem[j] = crc[j];
        }
        rem = divide(crc, divisor, rem);
        for(int i = 0; i< rem.length; i++){
            if(rem[i]!=0){
                System.out.println("error");
                break;
            }
            if(i == rem.length-1){
                System.out.println("no error");
            }
        }
        System.out.println("thank you...");
    }
    static int[] divide(int div[], int divisor[], int rem[]){
        int cur = 0;
        while(true){
            for(int i = 0; i< divisor.length; i++){
                rem[cur+i] = (rem[cur+i]^divisor[i]);
            }
            while(rem[cur] == 0 && cur!=rem.length-1){
                cur++;
            }
            if((rem.length-cur) < divisor.length){
                break;
            }
        }
        return rem;
    }
}