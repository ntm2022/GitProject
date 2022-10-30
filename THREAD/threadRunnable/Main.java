package threadRunnable;

public class Main {
    public static void main(String args[]) {
        System.out.println("Main thread running... ");

        RunnableDemo runnableDemo1 = new RunnableDemo("Thread-1-HR-Database");
        runnableDemo1.start();

        RunnableDemo runnableDemo2 = new RunnableDemo("Thread-2-Send-Email");
        runnableDemo2.start();

        System.out.println("Main thread stopped!!! ");
    }
}
/*
Main thread running...
Creating Thread-1-HR-Database
Starting Thread-1-HR-Database
Creating Thread-2-Send-Email
Starting Thread-2-Send-Email
Main thread stopped!!!
Running Thread-2-Send-Email
Running Thread-1-HR-Database
Thread: Thread-1-HR-Database, 4
Thread: Thread-2-Send-Email, 4
Thread: Thread-1-HR-Database, 3
Thread: Thread-2-Send-Email, 3
Thread: Thread-2-Send-Email, 2
Thread: Thread-1-HR-Database, 2
Thread: Thread-1-HR-Database, 1
Thread: Thread-2-Send-Email, 1
Thread Thread-1-HR-Database exiting.
Thread Thread-2-Send-Email exiting.

 */
