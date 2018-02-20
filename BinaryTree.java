
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList; 

public class BinaryTree {

	Node root;
	
	
	public void addNode(int key, String name){
		
		Node newNode = new Node(key, name);
		
		if(root==null){
			root = newNode;
		}else{
			
			Node focusNode = root;
			
			Node parent;
			
			while(true){
				
				parent = focusNode;
				
				if(key < focusNode.key){
					
					focusNode = focusNode.leftChild;
					
					if(focusNode == null){
						parent.leftChild = newNode;
						return;
					}
				}else{
						focusNode = focusNode.rightChild;
					
						if(focusNode == null){
							parent.rightChild = newNode;
							return;
				}
				
			}
		}
		
	}
}
	
	
	public Node find(int key){
		
		Node focusNode = root;
		
		while(focusNode.key != key){
			
			if(key < focusNode.key){
				focusNode = focusNode.leftChild;
			}else{
				focusNode = focusNode.rightChild;
			}
			
			if(focusNode == null){
				return null;
			}
			
		}
		
		return focusNode;
		
	}
	
	
	public int sizeTree(Node node){
		
		if(node == null){
			return 0;
		}
		
		
		return sizeTree(node.leftChild) + 1 + sizeTree(node.rightChild);
	}
	
	
	public boolean hasPathSum(Node node, int sum){
		
		if(node == null){
			return (sum==0);
		}
		
		boolean ans = false;
		
		int subSum = sum - node.key;
		
		if(subSum == 0 && node.leftChild == null && node.rightChild == null){
			return true;
		}
		if(node.leftChild != null){
			ans =  ans || hasPathSum(node.leftChild, subSum);
		}
		if(node.rightChild != null){
			ans =  ans || hasPathSum(node.rightChild, subSum);
		}
		return ans;
	}
	
	 boolean isBalanced(Node node){
		 if(node == null){
			 return true;
		 }
		 
		 int lh = height(node.leftChild);
		 int rh = height(node.rightChild);
		 
		 return Math.abs(lh-rh)>1 && isBalanced(node.leftChild) && isBalanced(node.rightChild);
		 
	 }
	 
	 int height(Node node){
		 if(node == null){
			 return 0;
		 }
		 
		 int lh = height(node.leftChild);
		 int rh = height(node.rightChild);
		 
		 return 1+ Math.max(height(node.leftChild), height(node.rightChild));
	 }
	 
	 int leafCount(Node node){
		if(node == null){
			return 0;
		}
		if(node.leftChild == null && node.rightChild == null){
			return 1;
		}
		
		return leafCount(node.leftChild) + leafCount(node.rightChild);
		 
	 }
	
	private void levelPrint(){
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		
		while(!queue.isEmpty()){
			
			Node tempNode = queue.poll();
			System.out.println(tempNode.key + " ");
			
			
			if(tempNode.leftChild != null){
				queue.add(tempNode.leftChild);
			}
			
			if(tempNode.rightChild != null){
				queue.add(tempNode.rightChild);
			}
		}
		
	}
	
	private void lineByLinePrint(){
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		q.add(null);
		
		
		while(!q.isEmpty()){
		
			Node temp = q.poll();
			
			if(temp != null){
				System.out.print(temp.key+ " ");
				
				if(temp.leftChild != null){
					q.add(temp.leftChild);
				}
				if(temp.rightChild != null){
					q.add(temp.rightChild);
				}
			}else{
				 if (!q.isEmpty()) {
	                    System.out.println();
	                    q.add(null);
	                }
			}
			
		}
		
	}
	
	
	private void inOrderTraversal(Node root){
		Node current= root;
		Stack<Node> stack = new Stack<Node>();
		
		
		while(current.leftChild != null){
			stack.push(current);
			current = current.leftChild;
		}
		
		while(!stack.isEmpty()){
			
			current = stack.pop();
			System.out.println(current.key);
			
			if(current.rightChild != null){
				current = current.rightChild;
				
				while(current.leftChild != null){
					stack.push(current);
					current = current.leftChild;
				}
			}
			
		}
		
		
	}
	
	private void  MorrisTraversal(Node root){
		
	}
	
	public void diagonalTraversal(Node root){

        Node ref = root;
        Queue<Node> q = new LinkedList<>();
        int count = 0;

        while(true){

            if(ref==null && q.isEmpty()){
                break;
            }

            while (ref != null){

                q.add(ref);
                System.out.print(" "+ ref.key);
                
                if(count == 0 && ref.rightChild == null){
                	System.out.println();
                	count = q.size();
                }
                
                ref = ref.rightChild;
                
       
                
            }

            if(ref==null && !q.isEmpty()){
                if(count == q.size())
                    System.out.println();
                Node temp = q.peek();
                if(temp.leftChild != null){
                    ref= temp.leftChild;
                }
                else
                    ref =null;

                q.remove();
                count--;
            }
        }
    }
	
    void printPaths(Node node) 
    {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }
	
    void printPathsRecur(Node node, int[] path, int pathLen) {
		
    	if(node == null){
    		return;
    	}
    	
    	path[pathLen] = node.key;
    	pathLen++;
    	
    	if(node.leftChild == null && node.rightChild == null) {
    		printPathsArray(path,pathLen);
    	}
    	else{
    		printPathsRecur(node.leftChild, path, pathLen);
    		printPathsRecur(node.rightChild, path, pathLen);
    	}
    	
	}





    void printPathsArray(int[] path, int pathLen) {
		
    	for(int i=0; i< pathLen ; i++){
    		System.out.print(path[i] + " ");
    	}
    	System.out.println();
    	
	}


	public static void main(String[] args) {
		
		BinaryTree BT = new BinaryTree();
		BT.addNode(30, "rish");
		BT.addNode(18, "fdsf");
		BT.addNode(36, "rish");
		BT.addNode(40, "rish");
		BT.addNode(15, "rish");
		BT.addNode(19, "rish");
		BT.addNode(23, "rish");
		//BT.lineByLinePrint();
		//BT.diagonalTraversal(BT.root);
		//System.out.println(BT.toString());
		
		//System.out.println((BT.find(4	)));
		
		System.out.println("Tree Size : " + BT.sizeTree(BT.root));
		System.out.println("Exists path of given sum : " + BT.hasPathSum(BT.root, 10));
		BT.printPaths(BT.root);
		
	}

	@Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}
}


class Node{
	
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key, String name){
		this.key = key;
		this.name = name;
		
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", name=" + name + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
	
	
	
}