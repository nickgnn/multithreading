public class MyThread implements Runnable {
    private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        boolean b = true;
        long a = 0;
        long start = System.currentTimeMillis();

        while (b) {
            ++a;
            if (System.currentTimeMillis() > start + counter.getTime()) {
                b = false;
            }
        }

        counter.setCount(counter.getCount() + a);
    }
}
