import java.util.concurrent.*;

void worker(int id, BlockingQueue<Integer> jobs, BlockingQueue<Integer> results) {
    while (true) {
        try {
            Integer j = jobs.poll(100, TimeUnit.MILLISECONDS);
            if (j == null) break;
            System.out.printf("worker %d started  job %d%n", id, j);
            Thread.sleep(1000);
            System.out.printf("worker %d finished job %d%n", id, j);
            results.put(j * 2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            break;
        }
    }
}

void main() throws Exception {
    final int numJobs = 5;
    var jobs = new LinkedBlockingQueue<Integer>(numJobs);
    var results = new LinkedBlockingQueue<Integer>(numJobs);

    for (int w = 1; w <= 3; w++) {
        final int id = w;
        Thread.ofVirtual().start(() -> worker(id, jobs, results));
    }

    for (int j = 1; j <= numJobs; j++) {
        jobs.put(j);
    }

    for (int a = 0; a < numJobs; a++) {
        results.take();
    }
}
