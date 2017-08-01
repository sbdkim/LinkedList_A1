/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
  Node root;//this will be the entry point to your linked list (the head)
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    root=new Node(0); //Note that the root's data is not a true part of your data set!
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return root;
  }

@Override
public boolean insert(Node n, int index) {
	// TODO Auto-generated method stub
	if (0 <= index && index <= size()){
		Node p = root;
		for (int i = 0; i < index; i++){
			p = p.next;
		}
		if (index == size()) {
			//if index at end of list
			p.next = n;
			n.prev = p;
			return true;
		}else{ 
			//index is in the middle of the list
			Node o = p.next;
			n.next = o;
			n.prev = p;
			
			o.prev = n;
			p.next = n;
			return true;
		}
	}else{
		return false;
	}
}
	

@Override
public boolean remove(int index) {
	// TODO Auto-generated method stub
	if(0 <= index && index < size()){
		Node o = root;
		for (int i = 0; i < index; i++){
			o = o.next;
		}
		if (index == size() - 1){
			//if index is at the end of the list
			o.next = null;
			return true;
		}else{
			//index is in the middle of the list
			Node p = o.next.next;
			o.next = p;
			p.prev = o;
			return true;
		}
	}else{
		return false;
	}
}

@Override
public Node get(int index) {
	// TODO Auto-generated method stub
	Node p = root.next;
	if (0 <= index && index < size()){
		for (int i = 0; i < index; i++){
			p = p.next;
		}
		return p;
	}else{
	return null;
	}
}

@Override
public int size() {
	// TODO Auto-generated method stub
	int counter = 0;
	Node p = root.next;
	while (p != null){
		p = p.next;
		counter++;
	}
	return counter;
}

@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return (size() == 0);
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	root = new Node(0);
}
}