public class Launch {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread[] threads = new Thread[Runtime.getRuntime().availableProcessors()];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new MyThread(counter));
        }

        for (Thread t : threads)
            t.start();

        try {
            for (Thread t : threads)
                t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println("Counter is: " + divide(counter.getCount()));
    }

    private static String divide(Long number) {
        StringBuilder result = new StringBuilder(String.valueOf(number));

        result.insert(result.length()-3, " ");
        result.insert(result.length()-7, " ");
        result.insert(result.length()-11, " ");

        return result.toString();
    }
}
