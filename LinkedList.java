
public class LinkedList {

	private Node head;
	
	class Node{
		private Node next;
		private int value;
		
		Node(int val){
			value = val;
			next=null;
		}
	}
	
	public void pushFirst(int data){
		Node newNode = new Node(data);
		
		if(head == null){
			head = new Node(data);
			return;
		}
		
		newNode.next = head;
		head = newNode;
		
		return;
	}
	
	public void pop(){
		if(head == null ){
			System.out.println("List is empty");
			return;
		}else{
			Node last = head;
			while(last.next.next != null){
				last = last.next;
			}
			last.next = null;
		return;
		}
		
	}
	
	public void deleteFirst(){
		if(head == null){
			System.out.println("List is empty");
			return;
		}else{
			Node first = head;
			head = head.next;
			first.next = null;
			
			return;
		}
	}
	
	public void deleteAtPosition(int pos){
		if(head ==  null){
			System.out.println("Linked list is Empty");
		}else{
			Node backNode;
			Node frontNode;
			backNode = head;
			for(int i=1; i< pos-1; i++){
				backNode = backNode.next;
			}
			frontNode = backNode.next.next;
			backNode.next = frontNode;
			
			return;
		}
		
	}
	
	public void pushAtPosition(int pos, int data){
		Node newNode = new Node(data);
		
		if(head == null){
			head = new Node(data);
			return;
		}
		
		Node backNode;
		Node frontNode;
		backNode = head;
		for(int i=0; i< pos-1 ; i++){
			backNode = backNode.next;
		}
		frontNode = backNode.next;
		backNode.next = newNode;
		newNode.next = frontNode;
		
		return;
	}
	
	public void append(int data){
		Node newNode = new Node(data);
		
		if(head == null){
			head = new Node(data);
			return;
		}
		
		newNode.next = null;
		
		Node last = head;
		
		while(last.next != null){
			last = last.next;
		}
		
		last.next = newNode;
		
		return;
	}

	public void reverseList(){
		
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
		PrintList();
	}
	

	private void loop() {
		Node slow = head;
		Node fast = head.next;
		
		while(slow != fast && slow.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast){
				
				System.out.println("Loop exist");
				System.out.println(slow.value);
				break;
			}
		}
		removeLoop(slow);
			
	}
	
	private void removeLoop(Node slow) {
			
		Node ptr1 = null;
		Node ptr2 = null;
		
		ptr1 = head;
		ptr2 = slow;
		
		while(true){
			ptr2 = slow;
			while(ptr2.next != ptr1 && ptr2.next != slow){
				ptr2 = ptr2.next;
			}
			
			if(ptr2.next == ptr1){
				System.out.println("ptr2 "+ ptr2.value);
				ptr2.next = null;
				break;
			}else{
				ptr1 = ptr1.next;
				System.out.println("ptr1 :" + ptr1.value);
			}
		}
	}
	
	
	private Node flattenList(Node node){
		
		if(node == null){
			return null;
		}
		
		Node last = node;
		
		return node;
		
		
	}

	private Node recursionReverse(Node curr, Node prev ){
        if (curr.next == null) {
            head = curr;
 
            curr.next = prev;
            return null;
        }
 
        Node next1 = curr.next;
 
        curr.next = prev;
        System.out.println("dsadas");
        recursionReverse(next1, curr);
        
        System.out.println("dsd");
        return head;
		
	}

	public void PrintList() {
		while(head != null){
			System.out.println(head.value);
			head = head.next;
		}
	}
		
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.append(5);
		list.append(6);
		list.append(8);
		list.append(9);
		
		//list.pushAtPosition(2, 7);
	//	list.pop();
		//list.deleteFirst();
	//	list.deleteAtPosition(2);
		
		System.out.println("head.next "+ list.head.next.value );
		System.out.println("head.next.next.next " + list.head.next.next.next.value);
		list.head.next.next.next = list.head.next;
		
		list.loop();
		/*Node prev = null;
		long start = System.currentTimeMillis();
		System.out.println(start);
		list.recursionReverse(list.head, prev);
		long end = System.currentTimeMillis();
		System.out.println(end);*/
		list.PrintList();
	}


}
