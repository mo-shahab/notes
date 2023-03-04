import java.io.*;

public class crc1 {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] data;
        int [] divisor;
        int [] rem;
        int [] crc;
        int [] div;
        int data_bits, divisor_bits, tot_length;
        System.out.println("enter the number of the data bits: ");
        data_bits = Integer.parseInt(br.readLine());
        data = new int[data_bits];
        System.out.println("enter the data bits: ");
        for(int i = 0; i< data_bits; i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("enter the number of the divisor bits");
        divisor_bits = Integer.parseInt(br.readLine());
        divisor = new int[divisor_bits];
        for(int i = 0; i< divisor_bits; i++){
            divisor[i] = Integer.parseInt(br.readLine());
        }

        tot_length = data_bits + divisor_bits -1;
        rem = new int[tot_length];
        div = new int[tot_length];
        crc = new int[tot_length];
        //crc generation
        System.out.println("dividened after appending 0s is: ");
        for(int i = 0; i< data.length; i++){
            div[i] = data[i];
        }
        for(int i = 0; i< div.length; i++){
            System.out.print(div[i]);
        }
        rem = divide(div, divisor, rem);
        for(int i = 0; i< div.length; i++){
            crc[i] = (div[i] ^ rem[i]);
        }
        System.out.println();
        System.out.println("the crc code is ");
        for(int i = 0; i< crc.length; i++){
            System.out.println(crc[i]);
        }
        System.out.println();
        System.out.println("enter the crc code: ");
        for(int i = 0; i < crc.length; i++){
            crc[i] = Integer.parseInt(br.readLine());
        }
        for(int j = 0; j < crc.length; j++){
            rem[j] = crc [j];
        }
        rem = divide(crc, divisor, rem);
        for(int i = 0; i< rem.length; i++){
            if(rem[i] != 0){
                System.out.println("error");
                break;
            }
            if(i == rem.length -1){
                System.out.println("no error");
            }
        }
        System.out.println("thank you");
    }
    static int [] divide(int div[], int divisor[], int rem[]){
        int cur = 0;
        while(true){
            for(int i = 0; i< divisor.length; i++){
                rem[cur+i] = (rem[cur+i]^divisor[i]);
            }
            while(rem[cur] == 0 && cur != rem.length -1){
                cur++;
            }
            if((rem.length - cur) < divisor.length){
                break;
            }
        }
        return rem;
    }
}