import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Main {
    private static FileOutputStream out;
    private static FileInputStream in;
    public static void main(String[] args) throws IOException {

        //Создание файла
        try {
            FileOutputStream out = new FileOutputStream("test.txt");
            for (int i = 0; i < 50; i++) {
                out.write(71);
            }

            //Вывод содержимого файла в консоль
            in = new FileInputStream("test.txt");
            for (int i = 0; i < 50; i++) {
                System.out.print(in.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //Создание еще 4 файлов и заполнение их
            for (int i = 0; i < 4; i++) {
                out  = new FileOutputStream("test" + Integer.toString(i) + ".txt");
                in = new FileInputStream("test" + (i - 1>=0?Integer.toString(i - 1):"") + ".txt");
                for (int j = 0; j < 50; j++) {
                    out.write(in.read() + 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Создание 5 потоков
        ArrayList<InputStream> al = new ArrayList<>();

        try {
            for (int i = 0; i < 5; i++) {
                al.add(new FileInputStream("test" + (i - 1>=0?Integer.toString(i - 1):"") + ".txt"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Перебор 5 потоков и объединение их в 1 файл
        Enumeration<InputStream> e = Collections.enumeration(al);
        try {
            out = new FileOutputStream("alltest.txt");
            while(e.hasMoreElements()) {
                InputStream v = e.nextElement();
                out.write(v.readAllBytes());
                v.close();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        out.close();
        in.close();

    }
}
