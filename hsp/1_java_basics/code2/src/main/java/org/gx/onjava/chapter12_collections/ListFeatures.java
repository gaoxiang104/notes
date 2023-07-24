package org.gx.onjava.chapter12_collections;
// List 特征

import java.util.*;

class Pet implements Comparable<Pet> {
    protected Integer id;
    private static int counter = 0;

    public Pet() {
        this.id = counter;
        counter++;
    }

    @Override
    public String toString() {
        return "Pet(" + id + ")";
    }

    @Override
    public int compareTo(Pet o) {
        if (this.id > o.id) {
            return 1;
        } else if (this.id == o.id) {
            return 0;
        }
        return -1;
    }
}

class PetCreator {
    public List<Pet> list(int size) {
        List<Pet> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(new Pet());
        }
        return result;
    }

    public Pet[] array(int length){
        return list(length).toArray(new Pet[]{});
    }
}

class Hamster extends Pet {
    @Override
    public String toString() {
        return "Hamster(" + id + ")";
    }
}

class Cymric extends Pet {
    @Override
    public String toString() {
        return "Cymric(" + id + ")";
    }
}

public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = new PetCreator().list(7);
        System.out.println("1: " + pets);
        Hamster h = new Hamster();
        pets.add(h); // 自动调整大小
        System.out.println("2: " + pets);
        System.out.println("3: " + pets.contains(h)); // 【.contains()】pets 是否包含 h
        pets.remove(h); // 【.remove()】按对象移除
        Pet p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p)); // 【.indexOf()】返回元素在List中的下标，
        Pet cymric = new Cymric();
        System.out.println("5: " + pets.indexOf(cymric));  // 【.indexOf()】元素不在List中，返回 -1
        System.out.println("6: " + pets.remove(cymric)); // 【.remove()】元素不在List中，返回 false
        // 必须是类型精确匹配的对象
        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);
        pets.add(3, new Pet()); // 在某个索引处添加
        System.out.println("9: " + pets);
        List<Pet> sub = pets.subList(1, 4); // 截取索引1（包含），到索引4（不包含）
        System.out.println("subList(1,4): " + sub);
        System.out.println("10: " + pets.containsAll(sub));
        Collections.sort(sub);
        System.out.println("sorted subList : " + sub);
        System.out.println("11: " + pets.containsAll(sub)); // 【.containsAll()】中，顺序并不重要
        Collections.shuffle(sub, rand); // 混合一下
        System.out.println("shuffle(sub,rand): " + sub);
        System.out.println("12: " + pets.containsAll(sub));
        List<Pet> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4)); // 注意：两个元素 get(1) 和 get(4)
        System.out.println("sub: " + sub);
        copy.retainAll(sub); // 【.retainAll()】copy 中仅仅保留 sub 的元素，其他都删除
        System.out.println("13: " + copy);
        copy = new ArrayList<>(pets); // 获取一个新副本
        copy.remove(2); // 按索引移除
        System.out.println("14: " + copy);
        copy.removeAll(sub); // 仅移除类型精确匹配的对象
        System.out.println("15: " + copy);
        copy.set(1,new Pet()); // 替换元素
        System.out.println("16: " + copy);
        copy.addAll(2,sub); // 在中间插入一个列表
        System.out.println("17: " + copy);
        System.out.println("18: " + pets.isEmpty()); // 【.pets()】判断List是否为空
        pets.clear(); // 【.clear()】移除所有元素
        System.out.println("19: " + copy);
        System.out.println("20: " + pets.isEmpty());
        pets.addAll(new PetCreator().list(4));
        System.out.println("21: "+pets);
        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);
        Pet[] pa = pets.toArray(new Pet[0]); // 【.toArray()】虽然指定`new Pet[0]`容量为0，toArray会自动扩容
        System.out.println("23: " + pa[3]);
    }
}
