import java.util.LinkedList;

public class QueueAsList {
    private  MyLinkedList lst;
    private int size;

    public QueueAsList() {
	lst = new MyLinkedList();
	size = 0;
    }

    public boolean isEmpty() {
        return lst.isEmpty();
    }

    public Object dequeue() {
        --size;
         return lst.deleteFirstNode();
    }

	public void enqueue(Object o) {
		lst.Append(o);
		++size;
    }
    public int getSize()
    {
        return size;
    }
    public Player getWinner()
    {
        if (size == 1)
        {
            return lst.getHead();
        }
        return null;
    }
}
