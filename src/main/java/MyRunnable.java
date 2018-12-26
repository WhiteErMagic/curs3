import java.io.FileOutputStream;

public class MyRunnable implements Runnable {
    private int myNumber;//Номер потока для очередности
    private int howMany;//Сколько уже напечатано из 5
    public MyRunnable(Next next, int myNumber) {
        this.myNumber = myNumber;
        this.howMany = 0;
    }

    //Для первой и второй задачи
    public MyRunnable(Next next) {
    }

    //Для третьей задачи
    public MyRunnable(Mfu mfu) {
    }

    public void run() {
    }

    //Установка количества уже напечатанного
    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    //Получение номера потока
    public int getMyNumber() {
        return myNumber;
    }

    //Получение количества уже напечатанного
    public int getHowMany() {
        return howMany;
    }
}

