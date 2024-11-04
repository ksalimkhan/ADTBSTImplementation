
public class BST {
	Node root; //attribute of the BST class
	
	public void insert(int key) {
		root = insertRecursiveAux(root, key); //optimizes the # of parameter acceptance in terms of the argument passing
		
	} //acts as a wrapper method to the main auxiliary method which is private scope
	private static Node insertRecursiveAux(Node root, int key) {
		if(root == null) { //if the root is null, then a new tree is established when insertion is called
			root = new Node(key); //creates a new root with the initial key of the tree to constructor
			return root; //returns the given root node
			
		} //base cases of the insertion method handled
		if(key < root.key) { //if the current key is less than the parent key, then key becomes a left child
			root.left = insertRecursiveAux(root.left, key); //assign left child of current parent node
			
		} else if(key > root.key) { //if the current key is greater than the parent key, then key becomes right
			root.right = insertRecursiveAux(root.right, key); //assign right child of current parent node
			
		}
		
		return root; //return the root after recursion back tracks from the base cases
		
		
	} //accepts both inputs as intended
	public void delete(int value) {
		root = deleteRecursiveAux(root, value); //optimizes the parameter acceptance in terms of the argument count
		
	} //acts as a wrapper method to the main auxiliary method
	private static Node deleteRecursiveAux(Node root, int value) {
		if(root == null) { //absolute base case where tree is empty, nothing to delete, return the nullified root
			return root;
			
		}
		if(root.key > value) { //if the current key of the current node is greater than the deletionValue
			root.left = deleteRecursiveAux(root.left, value); //assign the left node to the recursive method call
			//and throw in arguments root.left, and the deletion value
			
		} else if(root.key < value) { //same logic applies from comment above
			root.right = deleteRecursiveAux(root.right, value); //same logic applies from corresponding comment
			
		} else {
			//on the basis that the root only has a given right child
			if(root.left == null) {
				return root.right; //return the given existing child
				
			}
			//on the basis that the root only has a given left child
			if(root.right == null) {
				return root.left; //return the given existing child
				
			}
			//if both children are present for the node root then utilize successor algorithm
			Node successor = retrieveSuccessor(root); //the successor node is initialized to the method calling
			root.key = successor.key; //assign the current root.key to the successor key retrieved
			root.right = deleteRecursiveAux(root.right, successor.key); //call recursively utilizing the successor key
		
		}
		return root; //return the root ultimately
		
	} //accepts both inputs as intended
	private static Node retrieveSuccessor(Node current) {
		current = current.right;
		while(current != null && current.left != null) {
			current = current.left;
			
		}
		return current;
		
	} //auxiliary method to grab the successor for final baseCase
	
	void inOrder() {
		inOrder(root);
	
	}
	private void inOrder(Node root) {
		if(root != null) { //if the root does not equal to that of null execute the following
			inOrder(root.left); //LNR traversal, begin with the left farthest subtree
			System.out.print(root.key + " "); //print the following associated keys after recursive backtrack
			inOrder(root.right); //jump to the right most subtree and conduct the following
			
		}
	} //basic inOrder traversal for the output print statement	
	
	public static void main(String[] args) {
		//run test cases in main driver
		BST bst = new BST();
		//FIRST BST CREATION AND DELETION
		bst.insert(47);
		bst.insert(43);
		bst.insert(23);
		bst.insert(90);
		bst.insert(95);
		bst.insert(27);
		bst.insert(67);
		bst.insert(80);
		bst.insert(88);
		bst.insert(29);
		bst.insert(59);
		bst.insert(24);
		bst.insert(69);
		bst.insert(44);
		bst.insert(71);
		bst.insert(61);
		bst.insert(99);
		bst.insert(42);
		bst.insert(38);
		System.out.println("BST #1 - Prior to Deletion: ");
		bst.inOrder(); //TRAVERSAL OF THE FIRST BST PRIOR TO DELETION
		System.out.println();
		bst.delete(27);
		bst.delete(38);
		bst.delete(44);
		bst.delete(95);
		bst.delete(88);
		bst.delete(59);
		//FIRST BST CREATION AND DELETION
		System.out.println("BST #1 - After Deletion is Completed: ");
		bst.inOrder(); //TRAVERSAL OF THE FIRST BST AFTER DELETION
		System.out.println();
		//SECOND BST CREATTION AND DELETION
		BST bst2 = new BST();
		bst2.insert(17);
		bst2.insert(17);
		bst2.insert(15);
		bst2.insert(49);
		bst2.insert(34);
		bst2.insert(76);
		bst2.insert(59);
		bst2.insert(97);
		bst2.insert(69);
		bst2.insert(46);
		bst2.insert(86);
		bst2.insert(20);
		bst2.insert(99);
		bst2.insert(22);
		bst2.insert(52);
		bst2.insert(89);
		bst2.insert(57);
		bst2.insert(10);
		bst2.insert(41);
		bst2.insert(75);
		bst2.insert(37);
		System.out.println("BST #2 - Prior to Deletion: ");
		bst2.inOrder(); //TRAVERSAL OF THE SECOND BST PRIOR TO DELETION
		System.out.println();
		bst2.delete(99);
		bst2.delete(22);
		bst2.delete(69);
		bst2.delete(15);
		bst2.delete(10);
		bst2.delete(75);
		//SECOND BST CREATION AND DELETION
		System.out.println("BST #2 - After Deletion is Completed: ");
		bst2.inOrder(); //TRAVERSAL OF THE SECOND BST AFTER DELETION
				//Doing this to show Xavier something. 
