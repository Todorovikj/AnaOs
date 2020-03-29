public class Threads {
    public static void main(String[] args) throws InterruptedException {
        int finalResult;
        SumTo500 t1 = new SumTo500();
        SumFrom500To1000 t2= new SumFrom500To1000();
        t2.start();

        /*
         * If we write t2.join() here main thread will wait for t2 to finish
         * then it will start t1.
         *
         */
        t1.start();

        /*
         * Provides consistency that main thread will not continue
         * until t1 and t2 are finished.
         *
         * Without this every execution would return different results.
         */

        t1.join();
        t2.join();

        System.out.println("Main thread done t1 result:" +t1.result+" t2 result: "+t2.result );
        finalResult=t1.result + t2.result;
        System.out.println("FINAL RESULT :"+finalResult);
    }
}

class SumFrom500To1000 extends Thread{
    public int result;

    // Main thread logic
    public void run() {
        for (int i = 500; i <= 1000; i++) {
            this.result+=i;
            System.out.println("Sum from 500 to 1000: " +this.result);
        }
        System.out.println("Sum from 500 to 1000 done");
    }
}

class SumTo500 extends Thread {
    public int result;

    // Main thread logic
    public void run() {
        for (int i = 0; i < 500; i++) {
            this.result+=i;
            System.out.println("Sum to 500: " +this.result);
        }
        System.out.println("Sum TO 500 Done");
    }
}
