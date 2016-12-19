package holding;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Andrew on 2016/2/21.
 */
public class P27 {

    public static void main(String[] args) {
        Queue q = new LinkedList<>();
        for(String s : "L i n k e d L i s t".split(" ")){
            Command c = new Command(s);
            q = OfferMethod.offer(c);
        }
        ComsumeQueue cs = new ComsumeQueue();
        cs.comsume(q);

    }
}

class Command{

    public Command(String s){
        this.name = s;
    }
    private String name;

    public void operation(){
        System.out.println("name:"+name);
    }
}

class OfferMethod{

    private static Queue queue = new LinkedList<>();

    public static Queue offer(Command command){
        queue.offer(command);
        return queue;
    }
}

class ComsumeQueue{
    public void comsume(Queue<Command> q){
        while(q.peek() != null){
            q.remove().operation();
        }
    }

}