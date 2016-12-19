package com.code;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * simulate a web server to serve several clients, the goal is to ensure preasure the webserver can hold
 * every client need several time to be served , but the number of server is fixed
 * so the increase speed of client is need to be controlled , to maintain at a proper number
 * <p>
 * Created by Andrew on 2015/12/14.
 */
public class WebServerSimulation {


    public static final int MAX_SERVER_NUM = 50;

    public static void main(String[] args) {

        //generate the thread pool
        ExecutorService exec = Executors.newCachedThreadPool();

        //pass the requestCollection
        RequestCollection requestCollection = new RequestCollection(2000);

        //generate and start  the client generator
        ClientGenerator clientGenerator = new ClientGenerator(requestCollection);
        exec.execute(clientGenerator);

        //generate and start the web server
//        WebServer webServer = new WebServer(MAX_SERVER_NUM, requestCollection);
//        exec.execute(webServer);

        for(int i=0;i<10;i++){
            Server server = new Server(requestCollection);
            exec.execute(server);
        }

    }


    private static class ClientGenerator implements Runnable {

        private RequestCollection requestCollection;
        private Random random = new Random(47);

        public ClientGenerator(RequestCollection requestCollection) {
            this.requestCollection = requestCollection;
        }

        @Override
        public void run() {
            //maintain the requestCollection at a proper size
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(random.nextInt(300));
                    Request request = new Request(random.nextInt(1000));
                    requestCollection.put(request);

                    //test the number of requestingCollection


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}

class Request {
    private final long serviceTime;

    public Request(long serviceTime) {
        this.serviceTime = serviceTime;
    }

    public long getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }
}


class Server implements Runnable,Comparable<Server> {

    //identify
    private static int count = 0;
    private final int id = count++;
    private boolean servingRequest = true;
    private RequestCollection requestCollection;
    private int requestServed = 0;

    public Server(RequestCollection requestCollection) {
        this.requestCollection = requestCollection;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            Request request = requestCollection.poll();
            long time = request.getServiceTime();
            try {
                Thread.sleep(time);
                synchronized(this) {
                    requestServed++;
                }
                while(!servingRequest){
                    wait();
                }
            } catch (InterruptedException e) {
                System.out.println(id+" is interrupted");
            }
        }
        System.out.println(id+" is terminated");
    }

    @Override
    public int compareTo(Server o) {
        return requestServed < o.requestServed ? -1 : (requestServed == o.requestServed ? 0 : 1);
    }


}

class RequestCollection extends ArrayBlockingQueue<Request> {
    public RequestCollection(int maxLineSize) {
        super(maxLineSize);
    }

    public String toString() {
        if (this.size() == 0)
            return "[Empty]";
        StringBuilder result = new StringBuilder();
        for (Request request : this)
            result.append(request);
        return result.toString();
    }
}
