//CountMapClass


import java.util.Map;
import java.util.Objects;

public class CountMapClass <K> {
    private MyMap<K, Integer> map;
    public CountMapClass () {this.map = new MyMap<K, Integer>();}

    // добавляет элемент в этот контейнер.
    void add(K o) {
        boolean count = false;
        for(K i : map.keySet()) {
            if (i == o) {
                map.put(o, map.get(o) + 1);
                count = true;
            }
        }
        if (!count)
            map.put(o, 1);
    }

    //Возвращает количество добавлений данного элемента
    int getCount(K o) {
        return map.get(o);
    }

    //Удаляет элемент из контейнера, и возвращает количество его добавлений(до удаления)
    int remove(K o) {
        int n = getCount(o);
        map.remove(o);
        return n;
    }

    //количество разных элементов
    int size() {
        int count = 0;
        for(K i : map.keySet()) {
            count++;
        }
        return count;
    }

    //Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения
    void addAll(CountMapClass  source) {
        MyMap<K, Integer> gap = source.map;
        for(Object i : source.map.keySet()) {
            int count = 0;
            for(K j : map.keySet()) {
                if(j == i) {
                    map.put(j, gap.get((K) i) + map.get(j));
                    count++;
                    break;
                }
            }
            if(count == 0) {
                map.put((K)i, 1);
            }
        }
    }

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    Map toMap() {
        return (Map) map;
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map destination) {
        destination = (Map) map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountMapClass <?> CountMapClass  = (CountMapClass <?>) o;
        return map.equals(CountMapClass .map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}
