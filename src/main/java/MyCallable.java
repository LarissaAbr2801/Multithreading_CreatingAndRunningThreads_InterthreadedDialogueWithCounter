import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() {
        int counter = 0;
        try {
            while(counter < 10) {
                Thread.sleep(2500);
                System.out.println("Я " + Thread.currentThread().getName() + " Всем привет!");
                counter++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s завершен\n", Thread.currentThread().getName());
        }
        return counter;
    }
}
