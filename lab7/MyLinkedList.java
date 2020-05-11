class MyLinkedList {
    Node head=null; // head of list

    /* Linked list Node*/
    class Node {
        Player data;
        Node next;

        // Constructor to create a new node 
        // Next is by default initialized 
        // as null 
        Node(Player d) { data = d;
        next = null;
        }
    }
    // Method to insert a new node
    public  MyLinkedList insert(MyLinkedList list, Player data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }

    // Method to print the MyLinkedList.
    public static void printList(MyLinkedList list)
    {
        Node currNode = list.head;

        System.out.print("MyLinkedList: ");

        // Traverse through the MyLinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }
    public Player deleteFirstNode(){
        Node temp, curr = head;
        temp = curr;
        curr = curr.next;
        head = curr;
        return temp.data;
    }
    public void Append(Object player)
    {
        Node node = new Node((Player)player);
        if (head != null) {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
            node.next = null;
        }
        else{
            node.next = null;
            head = node;
        }

    }
    public Player getHead(){
        return head.data;
    }

}