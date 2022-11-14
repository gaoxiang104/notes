package org.gx.chapter14.p01;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {

    private static class Node<E> {
        // 前一个
        Node<E> pre;
        // 当前元素
        E item;
        // 后一个
        Node<E> next;

        public Node(Node<E> pre, E item, Node<E> next) {
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }

    private int size;

    private Node<E> first;

    private Node<E> last;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        linkedLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        return node(index).item;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        final Node<E> nowNode = node(index);
        nowNode.item = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        if (index == size) {
            linkedLast(element);
        } else {
            linkedBefore(element, node(index));
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        final Node<E> nowNode = node(index);
        final E element = nowNode.item;
        final Node<E> pre = nowNode.pre;
        final Node<E> next = nowNode.next;
        if (null == pre) {
            first = next;
        } else {
            pre.next = next;
            nowNode.pre = null;
        }

        if (null == next) {
            last = pre;
        } else {
            next.pre = pre;
            nowNode.next = null;
        }

        size--;
        return element;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = index - 1; i > index; i++) {
                x = x.pre;
            }
            return x;
        }
    }

    void linkedLast(E e) {
        final Node<E> l = last;
        final Node<E> nowNode = new Node<>(last, e, null);
        last = nowNode;
        if (null == l) {
            first = nowNode;
        } else {
            l.next = nowNode;
        }
        size++;
    }

    void linkedBefore(E element, Node<E> souc) {
        final Node<E> pre = souc.pre;
        final Node<E> nowNode = new Node<>(pre, element, souc);
        if (null == pre) {
            first = nowNode;
        } else {
            pre.next = nowNode;
        }
        size++;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (null != first) {
            Node<E> l = first;
            sb.append(l.item);
            while (true) {
                if (null == l.next) {
                    break;
                }
                l = l.next;
                sb.append(", ");
                sb.append(l.item);
            }
        }

        sb.append("]");
        return sb.toString();
    }
}

class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> l = new MyLinkedList<>();
        l.add("A");
        l.add("B");
        l.add("C");
        l.add("D");
        l.add("E");
        l.add("F");
        l.add("G");
        l.add("H");

        System.out.println(l);
        System.out.println(l.size());

        l.add(2, "123");
        System.out.println(l);
        System.out.println(l.size());

        // 修改
        l.set(2, "321");
        System.out.println(l);
        System.out.println(l.size());

        // 查
        System.out.println(l.get(2));

        // 删除
        l.remove(2);
        System.out.println(l);
        System.out.println(l.size());
    }
}