import java.util.ArrayList;
import java.util.List;

public class MyList<T> {
   private T[] obj = (T[]) new Object[5];
  private int countObj = 0;
  public static void main(String[] args) {
      MyList<Integer> myList = new MyList<>();
      myList.addObject(1);
      myList.addObject(2);
      myList.addObject(3);
      myList.addObject(4);
      myList.addObject(5);
      myList.addObject(6);
      myList.addObject(7);
      myList.removeObjectAtIndex(6);
      myList.removeObjectAtIndex(2);
      for (int i = 0; i < myList.countObj; i++) {
          System.out.println(myList.getObject(i));
      }

  }
  public void addObject(T o) {
      if (countObj >= obj.length) {
          T[] newObj = (T[]) new Object[obj.length * 3 / 2];
          for (int i = 0; i < obj.length; i++) {
              newObj[i] = obj[i];
          }
              obj = newObj;
      }
      obj[countObj] = o;
      countObj++;
  }
   //TODO removeObjectAtIndex - написать этот метод и под капотом removeObject должен он вызываться по найденному индексу. 
  public void removeObject(T o) {
      for (int i = 0; i < countObj; i++) {
          if (obj[i].equals(o)) {
              for (int j = i; j < countObj - 1; j++) {
                  obj[j] = obj[j + 1];
              }
              obj[countObj - 1] = null;
              countObj--;
          }
      }
  }
  public T getObject(int id) {
      return obj[id];
  }
  public void clear() {
      obj =(T[]) new Object[5];
      countObj = 0;
  }
  public void revers() {
      int a = obj.length - 1;
      T b;
      for(int i = 0; i < obj.length / 2; i++) {
          b = obj[i];
          obj[i] = obj[a];
          obj[a] = b;
          a--;
      }
  }
  public int size() {
      return countObj;
  }
  public void removeObjectAtIndex(int id) {
      T o = obj[id];
      removeObject(o);
  }
}
