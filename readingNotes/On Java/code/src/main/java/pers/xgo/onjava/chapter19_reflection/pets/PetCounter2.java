package pers.xgo.onjava.chapter19_reflection.pets;

public class PetCounter2 {
    public static void main(String[] args) {
        new PetCounter().count(new PetCreator());
    }
}
/* output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{EgyptianMau=2, Pug=3, Rat=2, Cymric=5, Mouse=2, Cat=9, Manx=7, Rodent=5, Mutt=3, Dog=6, Pet=20, Hamster=1}
 */