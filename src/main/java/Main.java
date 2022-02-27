public class Main {
    public static void main(String[] args) {

        CountMapClass<Integer> map1 = new CountMapClass<>();

        map1.add(2);
        map1.add(1);
        map1.add(2);
        map1.add(1);
        map1.add(1);
        map1.add(4);
        System.out.println(map1.getCount(1));  // 3
        System.out.println(map1.getCount(2));//2
        System.out.println(map1.getCount(4)); // 1

        System.out.println(map1.size()); // 3
    }
}