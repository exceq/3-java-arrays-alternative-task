public class SinglyLinkedList<T extends Object>{
    public T Value;
    public SinglyLinkedList<T> Previous;
    public int Length = 0;

    public SinglyLinkedList(T value, SinglyLinkedList<T> previous) {
        Value = value;
        Previous = previous;
        Length = previous.Length + 1;
    }

    public SinglyLinkedList(T value) {
        Value = value;
        Previous = null;
        Length = 1;
    }
}
