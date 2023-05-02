// Demonstrating thread collision over resources by
// reading an object in an unstable intermediate state.

// By Michael Madden, based on an example from Bruce Eckel's "Thinking in Java".

// The method next() is called infinitely in the main thread.
// We might expect that, since next() increments the value twice,
// a second thread calling getValue() will always get an even number,
// but this is not the case.
// If we declare BOTH next() and getValue() synchronized, the program
// works as expected.

public class AlwaysEven extends Thread
{
  private long i = 0;

  public void next() { i++; i++;  }
  public long getValue() { return i; }

  public void run()
  {
     // this defines a thread that watches whether the value is even
     while(true) {
       System.out.print("\n.");  // see how often we look
       long val = getValue();
       if(val % 2 != 0) {
          System.out.println("\nValue is not even!! It is " + val);
          System.exit(0);
       }
     }
  }

  public static void main(String[] args)
  {
    AlwaysEven ae = new AlwaysEven();
   	ae.start();    // start up watcher thread

    // in main program thread, keep calling next() to increment value twice
    while(true)
      ae.next();
  }
}