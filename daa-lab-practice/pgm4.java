import java.util.*;

class pgm4 {
    public static void main(String [] args) {
        Random r = new Random();
        System.out.println("enter the number of the elements");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i< n; i++){
            a[i] = r.nextInt(100);
        }
        System.out.println("elements before sort");
        for(int i = 0; i< n; i++){
        System.out.println(a[i]);
        }
        double t1 = System.nanoTime();
        quicksort(a, 0, n-1);
        System.out.println("elements after the sort");
        for(int i = 0; i< n; i++){
            System.out.println(a[i]);
        }
        double t2 = System.nanoTime();
        System.out.println("the time taken is " + (t2-t1));
    }

    public static int partition(int a[], int low, int high) {
        int i = low, j = high+1, temp;
        int pivot = a[low];
        while(i < j){
            do{
                i++;
            }while(pivot > a[i] && i < high);
            do{
                j--;
            }while(pivot < a[j]);
            if(i < j){
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        temp = a[j];
        a[j] = a[low];
        a[low] = temp;
        return j;
    }

    public static void quicksort(int a[], int low, int high){
        if(low<=high){
            int j = partition(a, low, high);
            quicksort(a, low, j-1);
            quicksort(a, j+1, high);
        }
    }
}