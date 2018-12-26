import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        threeThread();

        System.out.println("Задача 2");
        try {
            writeThread();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Задача 3");
        mfuThread();
    }

    private static void threeThread(){

        final Next whonext = new Next(1);

        Thread t1 = new Thread(new MyRunnable(whonext, 1) {
            Next next;
            public void run() {
                this.next = whonext;
                while(this.getHowMany() < 5) {
                    next.printSimbol(this,2, "A");
                }
            }
        });

        Thread t2 = new Thread(new MyRunnable(whonext, 2) {
            Next next;
            public void run() {
                this.next = whonext;
                while(this.getHowMany() < 5) {
                    next.printSimbol(this,3,"B");
                }
            }
        });

        Thread t3 = new Thread(new MyRunnable(whonext, 3) {
            Next next;
            public void run() {
                this.next = whonext;
                while(this.getHowMany() < 5) {
                    next.printSimbol(this,1,"C");
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    private static void writeThread() throws FileNotFoundException {
        final FileOutputStream file = new FileOutputStream("test.txt");
        final Next newNext = new Next(file);

        Thread t1 = new Thread(new MyRunnable(newNext){
            Next next;
            public void run() {
                this.next = newNext;
                for (int i = 0; i < 10; i++) {
                    this.next.writeToFile(70);
                }
            }
        });

        Thread t2 = new Thread(new MyRunnable(newNext){
            Next next;
            public void run() {
                this.next = newNext;
                for (int i = 0; i < 10; i++) {
                    this.next.writeToFile(71);
                }
            }
        });

        Thread t3 = new Thread(new MyRunnable(newNext){
            Next next;
            public void run() {
                this.next = newNext;
                for (int i = 0; i < 10; i++) {
                    this.next.writeToFile(72);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }

    private static void mfuThread(){
        final Mfu newMfu = new Mfu();

        Thread t1 = new Thread(new MyRunnable(newMfu){
            Mfu mfu;
            public void run() {
                this.mfu = newMfu;
                for (int i = 0; i < 10; i++) {
                    this.mfu.scan();
                }
            }
        });

        Thread t2 = new Thread(new MyRunnable(newMfu){
            Mfu mfu;
            public void run() {
                this.mfu = newMfu;
                for (int i = 0; i < 10; i++) {
                    this.mfu.scan();
                }
            }
        });

        Thread t3 = new Thread(new MyRunnable(newMfu){
            Mfu mfu;
            public void run() {
                this.mfu = newMfu;
                for (int i = 0; i < 10; i++) {
                    this.mfu.printDoc();
                }
            }
        });

        Thread t4 = new Thread(new MyRunnable(newMfu){
            Mfu mfu;
            public void run() {
                this.mfu = newMfu;
                for (int i = 0; i < 10; i++) {
                    this.mfu.printDoc();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
