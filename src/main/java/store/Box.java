package store;

import java.util.ArrayList;

public class Box <E extends Fruit>{
    private ArrayList<E> box;

    public Box() {
        this.box = new ArrayList<E>();
    }

    //Добавление фруктов в коробку
    public void addFruit(E item){
        this.box.add(item);
    }

    //Метод получения веса
    public float getWeight(){
        float weight = 0;
        for (int i = 0; i < this.box.size(); i++) {
            weight += this.box.get(i).getWeight();
        }
        return weight;
    }

    //Сравнение коробок
    public boolean Compare(Box new_box){
        if(getWeight() == new_box.getWeight())
            return true;
        else
            return false;
    }

    //Пересыпание фруктов в коробку-аргумент
    public void toBox(Box box){
        for (int i = 0; i < this.box.size(); i++) {
            box.addFruit(this.box.get(i));
        }
        this.box.clear();
    }

}
