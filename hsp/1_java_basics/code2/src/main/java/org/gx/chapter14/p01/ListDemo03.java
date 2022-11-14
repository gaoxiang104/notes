package org.gx.chapter14.p01;

import java.util.ArrayList;
import java.util.List;

public class ListDemo03 {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("红楼", "老曹", 8.8));
        bookList.add(new Book("三国", "老罗", 7.7));
        bookList.add(new Book("水浒", "老施", 6.6));
        System.out.println(bookList);
        for (int i = 0; i < bookList.size(); i++) {
            for (int j = 0; j < bookList.size() - 1; j++) {
                if (bookList.get(j).getPrice() > bookList.get(j + 1).getPrice()) {
                    Book tem = bookList.get(j);
                    bookList.set(j, bookList.get(j + 1));
                    bookList.set(j + 1, tem);
                }
            }
        }
        System.out.println(bookList);
    }

    static class Book {
        private String name;
        private String author;
        private Double price;

        public Book(String name, String author, Double price) {
            this.name = name;
            this.author = author;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"name\":\"")
                    .append(name).append('\"');
            sb.append(",\"author\":\"")
                    .append(author).append('\"');
            sb.append(",\"price\":")
                    .append(price);
            sb.append('}');
            return sb.toString();
        }
    }
}

