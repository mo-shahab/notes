import java.util.*;

class pgm5 {
    /**
     * @param args
     */
    public static void main(String [] args){
        Random r = new Random();
        System.out.println("enter the number of the elements");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i< n; i++){
            a[i] = r.nextInt(100);
        }
        System.out.println("the elements before the sort");
        for(int i = 0; i< n; i++){
            System.out.println(a[i]);
        }
        double t1 = System.nanoTime();
        mergesort(a, 0, n-1);
        System.out.println("the elements after the sort");
        for(int i = 0; i < n; i++){
            System.out.println(a[i]);
        }
        double t2 = System.nanoTime();
        System.out.println("the time taken is: " + (t2-t1));
    }
    public static void mergesort(int a[], int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            mergesort(a, low, mid);
            mergesort(a, mid+1, high);
            merge(a, low, high, mid);
        }
    }

    public static void merge(int a[], int low, int high, int mid){
        int h= low, j = mid+1;
        int i = low, k;
        int b[] = new int[high+1];
        while(h<=mid && j<=high){
            if(a[h]< a[j]){
                b[i] = a[h];
                h++;
            }
            else{
                b[i] = a[j];
                j++;
            }
            i++;
        }
        if(h > mid){
            for(k = j; k <= high; k++){
                b[i] = a[k];
                i++;
            }
        }
        else {
            for(k = h; k<=mid; k++){
                b[i] = a[k];
                i++;
            }
        }
        for(k = low; k <=high; k++){
            a[k] = b[k];
        }

    }
}