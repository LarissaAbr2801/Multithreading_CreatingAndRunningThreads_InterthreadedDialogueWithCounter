import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ExecutorService threadPool = Executors
                .newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<Integer>> tasks = List.of(new MyCallable(), new MyCallable(), new MyCallable(),
                new MyCallable());

        final List<Future<Integer>> results = threadPool.invokeAll(tasks);

        for (Future<Integer> result : results) {
            System.out.println("Количество выполнений: " + result.get());
        }

        //получение результата от одной из задач
        final Integer result = threadPool.invokeAny(tasks);

        System.out.println("\nКоличество выполнений: " + result);

        threadPool.shutdown();


    }

}