import java.util.concurrent.Semaphore;

public class Singleton {

    private static volatile Singleton singleton;
    public static Semaphore semaphore = new Semaphore(1);
    private Singleton() {

    }

    public static Singleton getInstance() {
        // TODO: 3/29/20 Synchronize this
        singleton = new Singleton();

        return singleton;
    }

    public static void main(String[] args) throws InterruptedException {
        Neshto n [] = new Neshto[100];
        for(int i =0; i<100;i++){
            n[i] = new Neshto();
        }
        for(Neshto i : n){
            i.run();
        }
        for(Neshto i : n){
            i.join();
        }
    }

}

class Neshto extends Thread implements Runnable{

    @Override
    public void run() {
        try {
            Singleton.semaphore.acquire();
            Singleton s = Singleton.getInstance();
            Singleton.semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
