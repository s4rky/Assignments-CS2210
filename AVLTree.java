
/* Class AVLTree */

 class AVLTree

 {
	private AVLNode root; public AVLTree Right; public AVLTree Left;
	
     //constructor AVLTree

     public AVLTree() {root = null;}

     /* Function to check if tree is empty */
     
     /**
      * contructor overloading
      * @param i
      */
     AVLTree(int i) {root = null;}

     //provided
     /**
      * 
      * @return
      */
	 public boolean isEmpty() {return root == null;}

     /* Make the tree logically empty */
	 //provided
     public void makeEmpty() {root = null;}

     /* Function to insert data */
     //provided
     public void Insert(int data) {root = insert(data, root);}

     /* Function to get height of node */
     //provided
     /**
      * 
      * @param t
      * @return
      */
     private int getheight(AVLNode t ) {return t == null ? -1 : t.height;}

     /* Function to max of left/right node */
     /**
      * 
      * @param lhs
      * @param rhs
      * @return
      */
     private int max(int lhs, int rhs) {return lhs > rhs ? lhs : rhs;}

     /* Function to insert data recursively */
     //private function
     /**
      * 
      * @param x
      * @param t
      * @return
      */
     //provided
     private AVLNode insert(int x, AVLNode t)

     {

         if (t == null)

             t = new AVLNode(x);

         else if (x < t.data)

         {

             t.left = insert( x, t.left );

             if( getheight( t.left ) - getheight( t.right ) == 2 )

                 if( x < t.left.data )

                     t = rotateWithLeftChild( t );

                 else

                     t = doubleWithLeftChild( t );

         }

         else if( x > t.data )

         {

             t.right = insert( x, t.right );

             if( getheight( t.right ) - getheight( t.left ) == 2 )

                 if( x > t.right.data)

                     t = rotateWithRightChild( t );

                 else

                     t = doubleWithRightChild( t );

         }

         else

           ;  // Duplicate; do nothing

         t.height = max( getheight( t.left ), getheight( t.right ) ) + 1;

         return t;


     }

     /* Rotate binary tree node with left child */   
     //provided
     /**
      * 
      * @param k2
      * @return k1
      */
     private AVLNode rotateWithLeftChild(AVLNode k2)

     {

         AVLNode k1 = k2.left;

         k2.left = k1.right;

         k1.right = k2;

         k2.height = max( getheight( k2.left ), getheight( k2.right ) ) + 1;

         k1.height = max( getheight( k1.left ), k2.height ) + 1;

         return k1;

     }

 

     /* Rotate binary tree node with right child */
     /**
      * 
      * @param k1
      * @return k2
      */
     private AVLNode rotateWithRightChild(AVLNode k1)

     {

         AVLNode k2 = k1.right;

         k1.right = k2.left;

         k2.left = k1;

         k1.height = max( getheight( k1.left ), getheight( k1.right ) ) + 1;

         k2.height = max( getheight( k2.right ), k1.height ) + 1;

         return k2;

     }

     /**
      * provided

      * Double rotate binary tree node: first left child

      * with its right child; then node k3 with new left child */
     /**
      * 
      * @param k3
      * @return rotateWithLeftChild( k3 )
      */
     private AVLNode doubleWithLeftChild(AVLNode k3)

     {

         k3.left = rotateWithRightChild( k3.left );

         return rotateWithLeftChild( k3 );

     }

     /**

      * Double rotate binary tree node: first right child

      * with its left child; then node k1 with new right child */      
     /**
      * 
      * @param k1
      * @return rotateWithRightChild( k1 )
      */
     private AVLNode doubleWithRightChild(AVLNode k1)

     {

         k1.right = rotateWithLeftChild( k1.right );

         return rotateWithRightChild( k1 );

     }    

     /* Functions to count number of nodes */
     //have to change name
     //provided
     /**
      * 
      * @return countNodes(root)
      */
     public int CountNumberNodes()

     {return countNodes(root);}
     
     //private
     /**
      * 
      * @param r
      * @return l
      */
     //provided
     private int countNodes(AVLNode r)

     {

         if (r == null)

             return 0;

         else

         {

             int l = 1;

             l += countNodes(r.left);

             l += countNodes(r.right);

             return l;

         }

     }

     /* Functions to search for an element */
     //change name
     
     /**
      * 
      * @param val
      * @return search(root, val)
      */
     //provided
     public boolean Search(int val) {return search(root, val);}
     /**
      * 
      * @param r
      * @param val
      * @return found
      */
     private boolean search(AVLNode r, int val)

     {

         boolean found = false;

         while ((r != null) && !found)

         {

             int rval = r.data;

             if (val < rval)

                 r = r.left;

             else if (val > rval)

                 r = r.right;

             else

             {

                 found = true;

                 break;

             }

             found = search(r, val);

         }

         return found;

     }

     /* Function for inorder traversal */
     //provided
     public void inorderTrav() {inorder(root);}
     //provided
     /**
      * 
      * @param r
      */
     private void inorder(AVLNode r)

     {

         if (r != null)

         {

             inorder(r.left);
             
             System.out.print(r.data +" ");
            
             inorder(r.right);
       
         }

     }

     /* Function for preorder traversal */
     //provided
     public void preorderTrav() {preorder(root);}
     //provided
     /**
      * 
      * @param r
      */
     private void preorder(AVLNode r)

     {

         if (r != null)

         {

             System.out.print(r.data +" ");

             preorder(r.left);             

             preorder(r.right);

         }

     }

     /* Function for postorder traversal */
     //provided
     public void postorderTrav(){postorder(root);}
     
  	 //provided
     /**
      * 
      * @param r
      */
     private void postorder(AVLNode r)

     {

         if (r != null)

         {

             postorder(r.left);             

             postorder(r.right);

             System.out.print(r.data +" ");

         }

     }

     											/* extra methods and functions */
     
   //gets the balance of the tree
     //getter
     /**
      * 
      * @param avlnode
      * @return return getheight(avlnode.left) - getheight(avlnode.right) or 0
      */
     private int returnbalance(AVLNode avlnode) {
		 if (avlnode != null)
			 return getheight(avlnode.left) - getheight(avlnode.right);
		 else {
	        return 0;
		 }
	}

     /**
      * 
      * @param AVL
      * @return AVL
      */
     private AVLNode balance_it(AVLNode AVL) {
 		
 		int abc;
 		abc = returnbalance(AVL);
 		
 		 if (abc >= 2 && AVL.left.data > root.data) {
 	            return rotateWithRightChild(AVL);
 		 }
 	        
	 		if (abc >= 2 && AVL.left.data < root.data) {
		            AVL.left = rotateWithLeftChild(AVL.left);
		            return rotateWithRightChild(AVL);
		    }
	 		if (abc <= -2 && AVL.right.data > root.data) {
 	            AVL.right = rotateWithRightChild(AVL.right);
 	            return rotateWithLeftChild(AVL);
 	        }
 	        if (abc <= -2 && AVL.right.data < root.data) {
 	            return rotateWithLeftChild(AVL);
 	        }
 	 
 	        return AVL;
 	}
     
     //printing the external node
     public void external() {
 		
    	AVLNode avl;
    	avl = root;
		    
		if(avl == null) 
			return; 
		
		if(avl.right == null && avl.left == null) {System.out.print(avl.data +"  ");}

	}
	
     //checks if tree is balanced
     /**
      * 
      * @param avl
      * @return
      */
     public boolean is_Balanced(AVLTree avl) {
 		
		  if(avl != null) {
			  balance_it(avl.root);
				return true;
		  }
		 
		  else {  
			  return false;
		  }

	}
     
    // changes the value field of entry to new value
	public void newvalue() {
		if (root == null) {
            System.out.println("NULL TREE");
            return;
        }
		
		else {
			
			AVLTree avlT;
			avlT = new AVLTree();
		
			while (avlT.isEmpty() == false) {
				 
	            //stores totol number of nodes at the current level
	            int length;
	            length = avlT.CountNumberNodes();
	 
	           //while the length is greater than 0, iterate...
	            while (length >= 1) { 
	                //sotring the front node as a temporary variable (i)
	                AVLNode i;
	                i = root;
	                //outputting value of the node we are currently at
	                System.out.print(
	                    i.data + "  ");
	                //while the node we are at.left is not null
	                if (i.right != null)
	                	avlT.insert(i.data, i.right);
	                if (i.left != null)
	                    //inserting node
	                    avlT.insert(i.data, i.left);
	                // Decrement length
	                length--;
	            }
	 
	            System.out.println();
	        }
		}
		
	}
	/**
	 * 
	 * @param avl
	 * @return
	 */
	public boolean BST(AVLTree avl) {
		if (avl.root == null) {return true;} 
		// false if: left is > than node or right is < than node... therefore -->
	    if ((root.left.data > avl.root.data && avl.root.left != null) || (root.right.data < avl.root.data && avl.root.right != null)) {
	    	return false;
	    }
	        
	    return true;
	}
	



 }


