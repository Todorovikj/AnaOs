import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class CountSeven {

    public static int NUM_RUNS = 10;
    /**
     * Promenlivata koja treba da go sodrzi brojot na pojavuvanja na elementot 7
     */
    int count = 0;
    /**
     * TODO: definirajte gi potrebnite elementi za sinhronizacija
     */
    Semaphore semaphore;
    public void init() {
        semaphore = new Semaphore(1);
    }

    class Counter extends Thread {

        private int[] data;

        public Counter(int[] data) {
            this.data = data;
        }

        public void count(int[] data) throws InterruptedException {
            int res=0;
            for(int br: data){
                if(br==7){
                    res++;
                }
            }
            if(res > 0){
                semaphore.acquire();
                count+=res;
                semaphore.release();
            }
        }

        @Override
        public void run() {
            try {
                count(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            CountSeven environment = new CountSeven();
            environment.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    // THIS START IS NOT FROM THREAD.START!!!! IT IS DUE TO BAD NAMING
    public void start() throws Exception {

        init();

        HashSet<Thread> threads = new HashSet<Thread>();
        Scanner s = new Scanner(System.in);
        int total=s.nextInt();

        for (int i = 0; i < NUM_RUNS; i++) {
            int[] data = new int[total];
            for (int j = 0; j < total; j++) {
                data[j] = s.nextInt();
            }
            Counter c = new Counter(data);
            threads.add(c);
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
        System.out.println(count);

    }
}
