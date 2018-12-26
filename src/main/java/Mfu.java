public class Mfu {
    int scan;//Отсканировано
    int pr;//Напечатано
    public Mfu() {
        this.scan = 0;
        this.pr = 0;
    }

    public synchronized void scan(){
        this.scan++;
        System.out.println("Отсканировано: " + Integer.toString(this.scan));
    }

    public synchronized void printDoc(){
        this.pr++;
        System.out.println("Отпечатано: " + Integer.toString(this.pr));
    }

}

