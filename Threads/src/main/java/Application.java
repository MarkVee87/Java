import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Application {

    public static void main(String args[]) {

//        threadOperation(new ArrayList<>());

        threadOperation(new CopyOnWriteArrayList<>());

    }

    private static void threadOperation(List<Integer> list) {
        System.out.println("starting");

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threads.add(
                    // create the thread
                    new Thread(() -> {
                        System.out.println(Thread.currentThread().getName());
                        list.add(1);

//                        list.toArray();
                        System.out.println(list);
                    }, "thread - " + i)
            );
        }

        // start execution
        threads.parallelStream()
                .forEach(Thread::start);

        System.out.println("finished");
        System.out.println(list);
    }
}
