import java.io.*;
import java.lang.reflect.Array;

public class Main2 {
    private static BufferedOutputStream out;
    private static BufferedInputStream in;
    public static void main(String[] args) {

        //Создаем файл >10мб и выводим постранично в консоль
        double timein = System.currentTimeMillis();
        try {
            out = new BufferedOutputStream(new FileOutputStream("bigtest.txt"));
            int alfavit = 90-65;
            int k = 10000000/1800/alfavit + 1;
            for (int a = 0; a < k; a++) {
                for (int i = 0; i <= alfavit; i++) {
                    for (int j = 0; j < 1800; j++) {
                        out.write(i + 65);
                    }
                    //out.write(System.lineSeparator().getBytes());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        double timein2 = System.currentTimeMillis();

        //Чтение из файла
        double timein3 = System.currentTimeMillis();
        try {
            in = new BufferedInputStream(new FileInputStream("bigtest.txt"));
            int c;
            char[] ch;
            byte[] buffer = new byte[1800];
            while ((c = in.read(buffer)) != -1) {
                ch = new char[1800];
                for (int i = 0; i < 1800; i++) {
                    ch[i] = (char)buffer[i];
                    buffer[i]=0;
                }
                System.out.println(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        double timein4 = System.currentTimeMillis();

        //Количество строк вывода в консоль большое и начало в консоли пропадает, поэтому вывожу время в конце
        System.out.println("Время запуска: " + Double.toString((timein2 - timein)/1000) + " с.");
        System.out.println("Время чтения: " + Double.toString((timein4 - timein3)/1000) + " с.");
    }
}
