class Linked{
    Node head;

    class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    public void printList(){
        if(head == null){
            System.out.println("This list is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }
    public void deleteFirst(){
        if(head == null){
            System.out.println("This list is empty");
            return;
        }
        head = head.next;
    }
    public void deleteLast(){
        if(head == null){
            System.out.println("This list is empty");
            return;
        }
        if(head.next==null){
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null; 
    }
    public boolean search(String data){
        if(head == null){
            System.out.println("List is Empty");
            return false;
        }
        Node currNode = head;
        while(currNode != null){
            if(currNode.data == data)
                return true;
            currNode = currNode.next;
        }
        return false;
    }

    public void reverse(){
        if(head == null || head.next ==null){
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode!=null){
            Node nextNode = currNode.next;
            currNode.next = prevNode; 
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next=null;
        head=prevNode;
    }
    public static void main(String[] args) {
        Linked list = new Linked();
        list.printList();
        list.addFirst("a");
        list.addFirst("is");
        list.addFirst("this");
        list.printList();
        list.addLast("list");
        list.printList();
        list.reverse();
        list.printList();
        System.out.println(list.search("this"));
        System.out.println(list.search("be"));
    }
}