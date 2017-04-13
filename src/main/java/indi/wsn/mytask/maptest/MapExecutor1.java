package indi.wsn.mytask.maptest;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MapExecutor1 {
    private static final int THREAD_SIZE = 500;
    private static final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    private static final Hashtable hashtable = new Hashtable();
    private static final ExecutorService service = Executors.newFixedThreadPool(THREAD_SIZE);

    public static void main(String[] args) throws InterruptedException {
        try {
            init();
            long timeBegin = System.currentTimeMillis();
            for (int j = 0; j < 10000; j++) {
                CountDownLatch countDownLatch = new CountDownLatch(THREAD_SIZE);
                for (int i = 0; i < THREAD_SIZE; i++) {
                    int doAction = 2;
                    MyRunnable runnable = new MyRunnable(doAction, countDownLatch, i);
                    service.execute(runnable);
                }
                countDownLatch.await();
            }
            long timeEnd = System.currentTimeMillis();
            System.out.println("task ends,and it costs " + (timeEnd - timeBegin));
        } finally {
            service.shutdown();
        }
    }

    private static void init() {
        int i = 0;
        while (i++ < 30000) {
            concurrentHashMap.put(i, i);
            hashtable.put(i, i);
        }
    }

    static class MyRunnable implements Runnable {
        private final int DO_ACTION;
        private CountDownLatch countDownLatch;
        private final int key;

        MyRunnable(int doAction, CountDownLatch countDownLatch, int key) {
            this.DO_ACTION = doAction;
            this.countDownLatch = countDownLatch;
            this.key = key;
        }

        @Override
        public void run() {
            try {
                if (DO_ACTION == 1) {
//                    concurrentHashMap.put(key, key);
                    concurrentHashMap.get(key);
//                    concurrentHashMap.size()
                } else {
//                    hashtable.put(key, key);
                    hashtable.get(key);
                }
            } finally {
                countDownLatch.countDown();
            }
        }
    }
}
