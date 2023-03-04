import java.util.*;

class RandomThread implements Runnable {
    public void run(){
        int num;
        Random r = new Random();
        try{
            for(int i = 0; i<5; i++){
                num = r.nextInt(100);
                System.out.println("first thread generated and the number is: " + num);
                Thread.sleep(1000);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class square implements Runnable {
    int x;
    public square(int x){
        this.x = x;
    }
    public void run(){
        System.out.println("from second thread square of" + x + " is " + x*x);
    }
}

class cube implements Runnable{
    int x;
    public cube(int x){
        this.x = x;
    }
    public void run(){
        System.out.println("from third thread the cube of " + x + " is " + x*x*x);
    }
}

class program3b {
    public static void main(String [] args) {
        try{
            Thread t1 = new Thread(new RandomThread());
            t1.start();
            int num = 10;
            Thread t2 = new Thread(new square(num));
            t2.start();
            Thread t3 = new Thread(new cube(num));
            t3.start();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}