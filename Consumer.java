public class Consumer extends Thread {
    private IntBuffer buffer;
    private int number, total;

    public Consumer(IntBuffer c, int num) {
    	buffer = c;
        number = num;
        total = 0;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = buffer.get();
            System.out.println("Consumer #" + number + " got: " + value);
            total += value;

            // This sleep can be commented out: changes dynamics of program
            try {
               sleep((int)(Math.random() * 500));
            } catch (InterruptedException e) { }
        }

        System.out.println("Total got by Consumer " + number + " = " + total);
    }
}
