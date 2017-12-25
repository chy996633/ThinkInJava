package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList<T> {

    private List<T> storage = new ArrayList<T>();
    private Random rand = new Random();

    public void put(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<Integer> randomList = new RandomList<>();
        for (Integer i : new int[]{ 2, 3, 546, 34, 123, 2, 1, 1234, 567, 478, 7655, 8 }) {
            randomList.put(i);
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(randomList.select());
        }
    }

}
