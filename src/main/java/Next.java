import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class Next {
    private int next;
    private FileOutputStream file;

    public Next(int next) {
        this.next = next;
    }

    public Next(FileOutputStream file) {
        this.file = file;
    }

    //Принимает текущий поток, номер следующего и самвол печати
    public synchronized void printSimbol(MyRunnable th, int whonext, String arg){

        //Сравниваем next - номер по очереди для печати и номер текущего потока
        if(next == th.getMyNumber()) {
            System.out.println(arg);

            //Какой поток должен печатать следующим
            next = whonext;

            //Увелим количество напечатанного
            th.setHowMany(th.getHowMany() + 1);

            notifyAll();

            //Если напечатали меньше 5 раз
            if(th.getHowMany() < 5) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeToFile(int arg){
        for (int i = 0; i < 10; i++) {
            try {
                this.file.write(arg);
                sleep(20);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
