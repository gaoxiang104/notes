package pers.xgo.onjava.chapter12_collections;

import java.util.List;
import java.util.ListIterator;

public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = new PetCreator().list(8);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()){
            System.out.println(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + ";");
        }
        System.out.println();
        // 反向
        while (it.hasPrevious()){
            System.out.print(it.previous() + " ");
        }
        System.out.println();
        System.out.println(pets);

        it = pets.listIterator(3);
        while (it.hasNext()){
            it.next();
            it.set(new Pet()); // 替换元素
        }
        System.out.println(pets);
    }
}
