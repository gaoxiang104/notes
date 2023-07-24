package org.gx.onjava.chapter12_collections;

import java.util.*;

public class CrossCollectionIteration2 {
    public static void display(Iterable<Pet> ib){
        Iterator<Pet> it = ib.iterator();
        while (it.hasNext()){
            Pet p = it.next();
            System.out.print(p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> pets = new PetCreator().list(8);
        LinkedList petsLL = new LinkedList(pets);
        HashSet<Pet> petsHS = new HashSet<>(pets);
        TreeSet<Pet> petsTS = new TreeSet<>(pets);
        display(pets);
        display(petsLL);
        display(petsHS);
        display(petsTS);
    }
}
