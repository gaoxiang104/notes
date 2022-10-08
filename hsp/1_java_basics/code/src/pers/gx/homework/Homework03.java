package pers.gx.homework;

/**
 * 3，编写类Book，定义方法updatePrice，实现更改某书的价格，具体：如果价格>150,则更改为150，如果价格>100，更改为100，否则不变
 */
public class Homework03 {
    public static void main(String[] args) {
        Book book = new Book(5.5d);

        book.updatePrice(150.1d);
        System.out.println("updatePrice '150.1d' , price : " + book.getPrice());
        book.updatePrice(149.5d);
        System.out.println("updatePrice '149.5d' , price : " + book.getPrice());
        book.updatePrice(88.8d);
        System.out.println("updatePrice '88.8d' , price : " + book.getPrice());
    }
}

class Book {

    private double price;

    public Book(double price){
        this.price = price;
    }

    public void updatePrice(double newPrice) {
        if(newPrice > 150){
            this.price = 150;
        } else if(newPrice > 100){
            this.price = 100;
        } else {
            this.price = newPrice;
        }
    }

    public double getPrice(){
        return this.price;
    }
}