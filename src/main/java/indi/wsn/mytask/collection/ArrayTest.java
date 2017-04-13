package indi.wsn.mytask.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by SharingWoo on 2017/4/11.
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] array = {1, 23, 3, 2, 45, 264, 34, 345, 43, 4};
        List list = Arrays.asList(array);
        for (Object i : list) {
            System.out.println(i == array);
        }
        //二分法查询
        int location = Arrays.binarySearch(array, 213);

        //数组截取复制(从头开始截取)
        int[] array2 = Arrays.copyOf(array, 2);

        //copyOfRange(可以指定范围)
        int[] array3 = Arrays.copyOfRange(array, 3, 7);

        //填充(如果原数组为空)，替换(如果原数组有值)
//        Arrays.fill(array,3);

        //默认升序
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        dog[] dogs = {new dog("1"), new dog("2"), new dog("3"), new dog("4"), new dog("5")};
        dog[] dogs2 = {new dog("11"), new dog("12"), new dog("13"), new dog("14")};

//        Collections.copy(Arrays.asList(dogs),Arrays.asList(dogs2));


//        Arrays.sort(dogs);
        //根据Comparator排序
//        Collections.sort(Arrays.asList(dogs), new dogCompare());
        //洗牌，打散原本的顺序
//        Collections.shuffle(Arrays.asList(dogs));
        //反转
//        Collections.reverse(Arrays.asList(dogs));
//        Collections.fill(dogs,new dog("2"));
        for (dog dog : dogs) {
            System.out.println(dog.getName());
        }
    }

    static class dog{
        private String name;

        public dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class cat {
        private String name;

        public cat(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class dogCompare implements Comparator<dog> {
        @Override
        public int compare(dog o1, dog o2) {
            return o1.name.length() >= o2.name.length() ? 1 : -1;
        }
    }
}
