package concurrency;//: concurrency/BankTellerSimulation.java
// Using queues and multithreading.
// {Args: 5}

import java.util.concurrent.*;
import java.util.*;

// Read-only objects don't require synchronization:
class Client {
    private final int serviceTime;

    public Client(int tm) {
        serviceTime = tm;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public String toString() {
        return "[" + serviceTime + "]";
    }
}

// Teach the customer line to display itself:
class ClientLine extends ArrayBlockingQueue<Client> {
    public ClientLine(int maxLineSize) {
        super(maxLineSize);
    }

    public String toString() {
        if (this.size() == 0)
            return "[Empty]";
        StringBuilder result = new StringBuilder();
        for (Client client : this)
            result.append(client);
        return result.toString();
    }
}

// Randomly add clientLine to a queue:
class ClientGenerator implements Runnable {
    private ClientLine clientLine;
    private static Random rand = new Random(47);
    public static long loadfactor = 1;

    public ClientGenerator(ClientLine cq) {
        clientLine = cq;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(100));
                clientLine.put(new Client(rand.nextInt(2000)));
                //adjust speed to add client
                Thread.sleep(1000/loadfactor);
            }
        } catch (InterruptedException e) {
            System.out.println("ClientGenerator interrupted");
        }
        System.out.println("ClientGenerator terminating");
    }
}

class Server implements Runnable, Comparable<Server> {
    private static int counter = 0;
    private final int id = counter++;
    // Customers served during this shift:
    private int requestsServed = 0;
    private ClientLine clients;
    private boolean servingCustomerLine = true;

    public Server(ClientLine cq) {
        clients = cq;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                Client client = clients.take();
                TimeUnit.MILLISECONDS.sleep(
                        client.getServiceTime());
                synchronized (this) {
                    requestsServed++;
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }

    public synchronized void doSomethingElse() {
        requestsServed = 0;
        servingCustomerLine = false;
    }

    public synchronized void serveCustomerLine() {
        assert !servingCustomerLine : "already serving: " + this;
        servingCustomerLine = true;
        notifyAll();
    }

    public String toString() {
        return "Server " + id + " ";
    }

    public String shortString() {
        return "T" + id;
    }

    // Used by priority queue:
    public synchronized int compareTo(Server other) {
        return requestsServed < other.requestsServed ? -1 :
                (requestsServed == other.requestsServed ? 0 : 1);
    }
}

class TellerManager implements Runnable {
    private ExecutorService exec;
    private ClientLine clientLine;
    private PriorityQueue<Server> workingServers =
            new PriorityQueue<Server>();
    private Queue<Server> tellersDoingOtherThings =
            new LinkedList<Server>();
    private int adjustmentPeriod;
    private static Random rand = new Random(47);
    private boolean stable = true;
    private int preSize = 0;

    public TellerManager(ExecutorService e,
                         ClientLine clientLine, int adjustmentPeriod, int n) {
        exec = e;
        this.clientLine = clientLine;
        this.adjustmentPeriod = adjustmentPeriod;

        for(int i =0;i<n;i++) {
            Server server = new Server(clientLine);
            exec.execute(server);
            workingServers.add(server);
        }

    }

    public void adjustTellerNumber() {

        if(clientLine.size() > preSize){
            if(stable){
                stable = false;

            }
            else if(!stable){
                System.out.println("max loadfactor : " + ClientGenerator.loadfactor);
                exec.shutdownNow();
            }
        }else {
            System.out.println("loadfactor : "+ ++ClientGenerator.loadfactor);
            stable = true;
        }

        preSize = clientLine.size();
    }

    // Give a teller a different job or a break:
    private void reassignOneTeller() {
        Server server = workingServers.poll();
        server.doSomethingElse();
        tellersDoingOtherThings.offer(server);
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();
                System.out.print(clientLine + " { ");
                for (Server server : workingServers)
                    System.out.print(server.shortString() + " ");
                System.out.println("}");
            }
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }

    public String toString() {
        return "TellerManager ";
    }
}

public class BankTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;
    public static final int SERVER_NUM = 5;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        // If line is too long, clientLine will leave:
        ClientLine customers =
                new ClientLine(MAX_LINE_SIZE);
        exec.execute(new ClientGenerator(customers));
        // Manager will add and remove tellers as necessary:
        exec.execute(new TellerManager(
                exec, customers, ADJUSTMENT_PERIOD, SERVER_NUM));
        if (args.length > 0) // Optional argument
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
} /* Output: (Sample)
[429][200][207] { T0 T1 }
[861][258][140][322] { T0 T1 }
[575][342][804][826][896][984] { T0 T1 T2 }
[984][810][141][12][689][992][976][368][395][354] { T0 T1 T2 T3 }
Teller 2 interrupted
Teller 2 terminating
Teller 1 interrupted
Teller 1 terminating
TellerManager interrupted
TellerManager terminating
Teller 3 interrupted
Teller 3 terminating
Teller 0 interrupted
Teller 0 terminating
ClientGenerator interrupted
ClientGenerator terminating
*///:~
