import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        IStorage<Integer> intStorage = new StorageImpl(3);
        intStorage.add(3);
        intStorage.add(2);
        intStorage.add(1);
        intStorage.display();

        ((StorageImpl<Integer>) intStorage).exchange(1,2);
        intStorage.display();
        ArrayList arr = ((StorageImpl<Integer>) intStorage).exportArr();
        System.out.println("ArrayList");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

        System.out.println("Sort");
        intStorage.sort();
        intStorage.display();


        List<Integer> values = new ArrayList<>();
        values.add(777);
        values.add(888);

        List<String> strValues = CollectionUtils.transform(values, String::valueOf);

        for (String strValue : strValues) {
            System.out.println(strValue);
        }

        IStorage<LocalDate> dateStorage = new StorageImpl(3);
        dateStorage.add(LocalDate.now());
        dateStorage.add(LocalDate.ofYearDay(2017, 1));
        ArrayList arr2 = ((StorageImpl) dateStorage).exportArr();
        System.out.println("ArrayList2");
        for (int i = 0; i < arr2.size(); i++) {
            System.out.println(arr2.get(i));
        }


        dateStorage.display();
        dateStorage.sort();
        dateStorage.display();
    }


}

