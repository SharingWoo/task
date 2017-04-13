//package indi.wsn.mytask.maptest;
//
//
//import static com.agent.SizeOfObject.fullSizeOf;
//import static java.lang.StrictMath.max;
//import static java.lang.System.nanoTime;
//import static java.lang.System.out;
//
//public class MapExecutor2 {
//
//    static void printSize(Object o) throws IllegalAccessException {
//        out.printf("类型：%s，占用内存：%.2f MB\n", o.getClass().getSimpleName(), fullSizeOf(o) / 1024D / 1024D);
//    }
//
//    static void printTime(Class type, Runnable r) {
//        double time = timeCall(r);
//        char[] rpad = "                                    ".toCharArray();
//        type.getSimpleName().getChars(0, type.getSimpleName().length(), rpad, 0);
//        out.printf("类型：%s \t 耗时：%.2g s\n", new String(rpad), time);
//    }
//    public static <T> double timeCall(Runnable call) {
//        long startA = nanoTime();
//        long start = nanoTime();
//        try {
//            call.run();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return 1E-9d * (max(0, nanoTime() - start - (start - startA))); // 减去 nanoTime() 本身的耗时;
//    }
//
//    public static void main(String[] args) throws Throwable {
//        int size = 1000000;
////
////        java.util.Map<Object, Object> javaUtilHashMap = new java.util.HashMap<>();
////        for (int i = 0; i < size; javaUtilHashMap.put(i, i), i++) {
////        }
////
////        net.openhft.koloboke.collect.map.hash.HashIntIntMap openHftHashIntIntMap =
////                net.openhft.koloboke.collect.map.hash.HashIntIntMaps.newUpdatableMap();
////        for (int i = 0; i < size; openHftHashIntIntMap.put(i, i), i++) {
////        }
////
////        java.util.ArrayList<Object> javaUtilArrayList = new java.util.ArrayList<>();
////        for (int i = 0; i < size; javaUtilArrayList.add(i), i++) {
////        }
////
////        Integer[] objectArray = new Integer[size];
////        for (int i = 0; i < size; objectArray[i] = i, i++) {
////        }
////
////        com.carrotsearch.hppc.IntArrayList hppcArrayList = new com.carrotsearch.hppc.IntArrayList();
////        for (int i = 0; i < size; hppcArrayList.add(i), i++) {
////        }
////
////        int[] primitiveArray = new int[size];
////        for (int i = 0; i < size; primitiveArray[i] = i, i++) {
////        }
//
//
////        printTime(java.util.HashMap.class, () -> {
////            java.util.Map<Object, Object> javaUtilHashMap = new java.util.HashMap<>();
////            for (int i = 0; i < size; javaUtilHashMap.put(i, i), i++) {
////            }
////        });
//
////        printTime(java.util.LinkedHashMap.class, () -> {
////            java.util.Map<Object, Object> javaUtilLinkedHashMap = new java.util.LinkedHashMap<>();
////            for (int i = 0; i < size; javaUtilLinkedHashMap.put(i, i), i++) {
////            }
////        });
////
////
////        printTime(java.util.concurrent.ConcurrentHashMap.class, () -> {
////            java.util.Map<Object, Object> javaUtilLinkedHashMap = new java.util.concurrent.ConcurrentHashMap<>();
////            for (int i = 0; i < size; javaUtilLinkedHashMap.put(i, i), i++) {
////            }
////        });
////
////
////        printTime(Collections.synchronizedMap(new java.util.concurrent.ConcurrentHashMap()).getClass(), () -> {
////            java.util.Map<Object, Object> javaUtilLinkedHashMap = Collections.synchronizedMap(new java.util.concurrent.ConcurrentHashMap());
////            for (int i = 0; i < size; javaUtilLinkedHashMap.put(i, i), i++) {
////            }
////        });
////
////        printTime(java.util.TreeMap.class, () -> {
////            java.util.Map<Object, Object> javaUtilTreeMap = new java.util.TreeMap<>();
////            for (int i = 0; i < size; javaUtilTreeMap.put(i, i), i++) {
////            }
////        });
////
////        printTime(net.openhft.koloboke.collect.map.hash.HashIntIntMaps.newUpdatableMap().getClass(), () -> {
////            net.openhft.koloboke.collect.map.hash.HashIntIntMap openHftHashIntIntMap =
////                    net.openhft.koloboke.collect.map.hash.HashIntIntMaps.newUpdatableMap();
////            for (int i = 0; i < size; openHftHashIntIntMap.put(i, i), i++) {
////            }
////        });
////
////        printTime(java.util.ArrayList.class, () -> {
////            java.util.ArrayList<Object> javaUtilArrayList = new java.util.ArrayList<>();
////            for (int i = 0; i < size; javaUtilArrayList.add(i), i++) {
////            }
////        });
////
////        printTime(Integer[].class, () -> {
////            Integer[] objectArray = new Integer[size];
////            for (int i = 0; i < size; objectArray[i] = i, i++) {
////            }
////        });
////
////        printTime(com.carrotsearch.hppc.IntArrayList.class, () -> {
////            com.carrotsearch.hppc.IntArrayList hppcArrayList = new com.carrotsearch.hppc.IntArrayList();
////            for (int i = 0; i < size; hppcArrayList.add(i), i++) {
////            }
////        });
////
////        printTime(int[].class, () -> {
////            int[] primitiveArray = new int[size];
////            for (int i = 0; i < size; primitiveArray[i] = i, i++) {
////            }
////        });
//        out.println("java.vm.name=" + System.getProperty("java.vm.name"));
//        out.println("java.vm.version=" + System.getProperty("java.vm.version"));
//        out.println("容器元素总数：" + size);
//
////        printSize(javaUtilHashMap);
////        printSize(openHftHashIntIntMap);
////        printSize(javaUtilArrayList);
////        printSize(hppcArrayList);
////        printSize(primitiveArray);
////        printSize(objectArray);
//    }
//}