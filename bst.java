package dsaUsingJava;
public class bst {
  private Node root;
  class Node{
    int value;
    Node left;
    Node right;
    Node(int value){
      this.value=value;
    }
  }
  public boolean insert(int value){
    Node newNode=new Node(value);
    if(root==null){
      root=newNode;
      return true;
    }
    Node temp=root;
    while(true){
      if(newNode.value==temp.value)
        return false;
      if(newNode.value<temp.value){
        if(temp.left==null){
          temp.left=newNode;
          return true;
        }
          temp=temp.left;
      }else{
        if(temp.right==null){
          temp.right=newNode;
          return true;
        }
          temp=temp.right;
      }
    }
  }
  public boolean contains(int value){
    Node temp=root;
    while(temp!=null){
      if(value<temp.value)
        temp=temp.left;
      else if(value>temp.value)
        temp=temp.right;
      else
        return true;
      }
      return false;

  }
public static void main(String[] args) {
  bst b=new bst();
  System.out.println(b.root);
  b.insert(47);
  b.insert(21);
  b.insert(76);
  b.insert(18);
  b.insert(52);
  b.insert(82);
  b.insert(27);
  System.out.println(b.contains(17));
  System.out.println(b.contains(27));
  System.out.println(b.root.left.right.value);
}

}
