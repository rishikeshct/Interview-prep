
class NodeTree
{
  int data;
  NodeTree left, right;

  NodeTree(int item) 
  {
      data = item;
      left = right = null;
  }
}

class BoundaryClass {

  NodeTree root;

  void printLeaves(NodeTree NodeTree) 
  {

	  if(NodeTree != null){
		  
		printLeaves(NodeTree.left);
		
		if(NodeTree.left == null && NodeTree.right == null){
			System.out.print(NodeTree.data + " ");
		}
		printLeaves(NodeTree.right);
	  }
	  
  }

  void printBoundaryLeft(NodeTree NodeTree) 
  {

	  if(NodeTree != null){
		  
		  if(NodeTree.left != null){
			  
			  System.out.print(NodeTree.data + " ");
			  printBoundaryLeft(NodeTree.left);
			  
		  }
		  else if (NodeTree.right != null) {
			
			  System.out.print(NodeTree.data + " ");
			  printBoundaryLeft(NodeTree.right);
		}
			  
	  }
	  
  }


  void printBoundaryRight(NodeTree NodeTree) 
  {

	  if(NodeTree != null){
		  if(NodeTree.right != null){
			  
			  printBoundaryRight(NodeTree.right);
			  System.out.print(NodeTree.data +" ");
		  }
		  else if (NodeTree.left != null) {
			printBoundaryRight(NodeTree.left);
			System.out.print(NodeTree.data + " ");
		}
	  }
	  
  }

  void printBoundary(NodeTree NodeTree) 
  {
      if (NodeTree != null) 
      {
          System.out.print(NodeTree.data + " ");

          // Print the left boundary in top-down manner.
          printBoundaryLeft(NodeTree.left);

          // Print all leaf NodeTrees
          printLeaves(NodeTree.left);
          printLeaves(NodeTree.right);

          // Print the right boundary in bottom-up manner
          printBoundaryRight(NodeTree.right);
      }
  }
  
  boolean identicalBinaryTree(NodeTree t1, NodeTree t2){
	  
	  if(t1==null && t2 == null){
		  return true;
	  }
	  if(t1 !=null || t2 != null){
		  
		  return (t1.data == t2.data && identicalBinaryTree(t1.left, t2.left) && identicalBinaryTree(t1.right, t2.right));
		  
	  }
	  
	return false;
	  
  }
     
  // Driver program to test above functions
  public static void main(String args[]) 
  {
	  BoundaryClass tree = new BoundaryClass();
      tree.root = new NodeTree(20);
      tree.root.left = new NodeTree(8);
      tree.root.left.left = new NodeTree(4);
      tree.root.left.right = new NodeTree(12);
      tree.root.left.right.left = new NodeTree(10);
      tree.root.left.right.right = new NodeTree(14);
      tree.root.right = new NodeTree(22);
      tree.root.right.right = new NodeTree(25);
      tree.printBoundary(tree.root);
      
	  BoundaryClass tree1 = new BoundaryClass();
      tree1.root = new NodeTree(20);
      tree1.root.left = new NodeTree(8);
      tree1.root.left.left = new NodeTree(4);
      tree1.root.left.right = new NodeTree(12);
      tree1.root.left.right.left = new NodeTree(10);
      tree1.root.left.right.right = new NodeTree(14);
      tree1.root.right = new NodeTree(22);
      tree1.root.right.right = new NodeTree(25);
      System.out.println();
      System.out.println(tree.identicalBinaryTree(tree.root, tree1.root));
  }
}