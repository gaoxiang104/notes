package org.gx.onjava.charpter12_collections;

import java.util.Iterator;

class PetSequence {
    protected Pet[] pets = new PetCreator().array(8);
}
public class NoCollectionSequence extends PetSequence{
    public Iterator<Pet> iterator(){
        return new Iterator<Pet>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    public static void main(String[] args) {
        NoCollectionSequence nc = new NoCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }
}
