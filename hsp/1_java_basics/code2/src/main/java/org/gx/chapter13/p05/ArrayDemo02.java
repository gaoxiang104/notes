package org.gx.chapter13.p05;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayDemo02 {

    public static void main(String[] args) {
        Book b1 = new Book("红楼梦", 20.0);
        Book b2 = new Book("金瓶梅新", 30.0);
        Book b3 = new Book("青年文摘20年", 10.0);
        Book b4 = new Book("Java从入门到放弃", 88.0);

        Book[] books = {b1, b2, b3, b4};
        System.out.println("排序前：" + Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double t = o1.getPrice() - o2.getPrice();
                if (t > 0) {
                    return 1;
                } else if (t < 0) {
                    return -1;
                }
                return 0;
            }
        });
        System.out.println("价格排序(正序)：" + Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double t = o2.getPrice() - o1.getPrice();
                if (t > 0) {
                    return 1;
                } else if (t < 0) {
                    return -1;
                }
                return 0;
            }
        });
        System.out.println("价格排序(倒序)：" + Arrays.toString(books));

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getName().length() - o1.getName().length();
            }
        });
        System.out.println("书名长度排序：" + Arrays.toString(books));
    }

    static class Book {
        private String name;
        private double price;

        public Book(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"name\":\"")
                    .append(name).append('\"');
            sb.append(",\"price\":")
                    .append(price);
            sb.append('}');
            return sb.toString();
        }
    }
}

