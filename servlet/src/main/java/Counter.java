public class Counter {
  public static Counter COUNTER = new Counter();

  private int value;

  public Counter() {
    value = 0;
  }

  public int getCounter() {
    return value;
  }

  public void increment() {
    value++;
  }

  public void decrement(int number) {
    if (number < value) {
      value -= number;
    } else {
      value = 0;
    }
  }

  public void clear() {
    value = 0;
  }
}
