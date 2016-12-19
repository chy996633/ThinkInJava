package generics;//: generics/BankTeller.java
// A very simple bank teller simulation.
import chapter15.Generator;
import chapter15.Generators;

import java.util.*;


class Customer {
  private static long counter = 1;
  private final long id = counter++;
  private Customer() {}
  public String toString() { return "Client " + id; }
  // A method to produce Generator objects:
  public static Generator<Customer> generator() {
    return new Generator<Customer>() {
      public Customer next() { return new Customer(); }
    };
  }
}	

class Teller {
  private static long counter = 1;
  private final long id = counter++;
  private Teller() {}
  public String toString() { return "Teller " + id; }
  // A single Generator object:
  public static Generator<Teller> generator =
    new Generator<Teller>() {
      public Teller next() { return new Teller(); }
    };
}	

public class BankTeller {
  public static void serve(Teller t, Customer c) {
    System.out.println(t + " serves " + c);
  }
  public static void main(String[] args) {
    Random rand = new Random(47);
    Queue<Customer> line = new LinkedList<Customer>();
    Generators.fill(line, Customer.generator(), 15);
    List<Teller> tellers = new ArrayList<Teller>();
    Generators.fill(tellers, Teller.generator, 4);
    for(Customer c : line)
      serve(tellers.get(rand.nextInt(tellers.size())), c);
  }	
} /* Output:
Teller 3 serves Client 1
Teller 2 serves Client 2
Teller 3 serves Client 3
Teller 1 serves Client 4
Teller 1 serves Client 5
Teller 3 serves Client 6
Teller 1 serves Client 7
Teller 2 serves Client 8
Teller 3 serves Client 9
Teller 3 serves Client 10
Teller 2 serves Client 11
Teller 4 serves Client 12
Teller 2 serves Client 13
Teller 1 serves Client 14
Teller 1 serves Client 15
*///:~
