class BasicDLL {
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.prev = currNode;
    }

    public void printList(){
        if(head == null){
            System.out.println("This list is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "<->");
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
        head.prev = null;
    }
    public void deleteLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.prev.next = null;
        currNode.prev = null;
    }
    public boolean search(int data){
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
    //   1st Method:-
    // public void reverse(){
    //     if(head == null || head.next == null){
    //         return;
    //     }
    //     Node currNode = head.next;
    //     head.prev = head.next;
    //     head.next = null;
    //     while(currNode.next != null){
    //         Node tempNode = currNode.next;
    //         currNode.next = currNode.prev;
    //         currNode.prev = tempNode;
    //         currNode = tempNode;
    //     }
    //     currNode.next = currNode.prev;
    //     currNode.prev = null;
    //     head = currNode;
    // }

    // 2nd Method:-
    public void reverse(){
        if(head == null){
            return;
        }
        Node currNode = head;
        while(currNode != null){
            Node tempNode = currNode.next;
            currNode.next = currNode.prev;
            currNode.prev = tempNode;
            if(currNode.prev == null)
                head = currNode;
            currNode = currNode.prev;

        }
    }

        public static void main(String[] args) {
        BasicDLL list = new BasicDLL();
        list.printList();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.printList();
        list.addLast(4);
        list.printList();
        list.reverse();
        list.printList();
        System.out.println(list.search(5));
        System.out.println(list.search(2));
    }
}
