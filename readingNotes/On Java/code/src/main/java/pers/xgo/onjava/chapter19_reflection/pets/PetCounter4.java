package pers.xgo.onjava.chapter19_reflection.pets;

public class PetCounter4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        new PetCreator().stream().limit(20).peek(counter::count)
                .forEach(p -> System.out.print(p.getClass().getSimpleName() + " "));
        System.out.println("\n" + counter);
    }
}
/* output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Cymric=5, Rodent=5, Pet=20, Pug=3, Hamster=1, Cat=9, Rat=2, Manx=7, Mouse=2, Dog=6, Mutt=3, EgyptianMau=2}
 */