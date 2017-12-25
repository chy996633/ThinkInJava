package generics;

public class LinkedStack<T> {

    private class Node<U>{
        private U item;
        Node<U> next;
        public Node(){ item = null; next = null;}
        public Node(U item, Node<U> next){
            this.item = item;
            this.next = next;
        }
        Boolean end(){ return item == null && next == null;}
    }

    Node<T> top = new Node<T>();

    public void push(Node<T> node){
        top = new Node(node, top);
    }

    public T pop(){
        T item = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return item;
    }




}
