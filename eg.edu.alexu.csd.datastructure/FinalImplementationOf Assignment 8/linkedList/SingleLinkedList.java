package linkedList;

public class SingleLinkedList implements ILinkedList {
	public static class SingleLinkedListNode {
		private Object element;
		private SingleLinkedListNode next;
		/**initialize the single linked list node */
		public SingleLinkedListNode(Object newElem, SingleLinkedListNode n) {
			element= newElem;
			next = n;
		}
		public SingleLinkedListNode() {
			element= null;
			next = null;
		}
		public SingleLinkedListNode(Object newElem) {
			element= newElem;
			next = null;
		}
		/** Returns the element of this node. */
		public Object getElement() {
				return element; 
			}
		/** Returns the next node of this node. */
		public SingleLinkedListNode getNext() {
				return next; 
			}
		// Modifier methods:
		/** Sets the element of this node. */
		public void setElement(Object newElem) {
				element = newElem;
			}
		/** Sets the next node of this node. */
		public void setNext(SingleLinkedListNode newNext) {
				next = newNext;
			}
	}
	///////////////////////the linked list//////////////////////////
	public SingleLinkedListNode head; // head node of the list
	private int size; // number of nodes in the list
	/** Default constructor that creates an empty list */
	public SingleLinkedList(){
	head = null;
	size = 0;
	            }
	@Override
	public void add(int index, Object element) {
		SingleLinkedListNode node = new SingleLinkedListNode();
		node.setElement(element);
		node.setNext(null);
	/*	if(head==null) {
			head = node;
			head.setNext(null);
			size++;
		}
		else {*/
			if(index==0) {
				node.setNext(head);
				head=node;
				size++;
			}
			else {
				    if(index>size || index <0) {
				    	NullPointerException nullPointer = new NullPointerException();
	                    throw nullPointer;
				    }
				    else {
				    SingleLinkedListNode n =head;
					for(int i=0;i<index-1;i++) {
						n=n.getNext();
					}
					node.setNext(n.getNext());
					n.setNext(node);
					size++;
				    }
			}
		//}
		
		
	}
	@Override
	public void add(Object element) {
		add(this.size,element);
		
	}
	@Override
	public Object get(int index) {
		if(index>size || index <0) {
	    	NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
	    }
		else {
		SingleLinkedListNode n =head;
		for(int i=0;i<index;i++) {
			n=n.getNext();
		}
		if(n.getElement()==null)
			return 1;
		return n.getElement();
		}
	}
	@Override
	public void set(int index, Object element) {
		if(index>size || index <0) {
	    	NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
	    }
		else {
		SingleLinkedListNode node =head;
		for(int i=0;i<index;i++) {
			node=node.getNext();
		}
		node.setElement(element);
		}
	}
	@Override
	public void clear() {
		if (size!=0) {
			while (head.getNext() != null) {
				head = head.getNext();
				size--;
			}
			head = head.getNext();
			size--;
		}
	}
	@Override
	public boolean isEmpty() {
		boolean test=false;
			//if(head==null) we can use this also
			if(size==0) {
				test = true;
			}
		return test;
	}
	@Override
	public void remove(int index) {
		if(index==0) {
			head=head.getNext();
			size--;
		}
		else {
			if(index>size || index <0) {
		    	NullPointerException nullPointer = new NullPointerException();
                throw nullPointer;
		    }
			else {
				SingleLinkedListNode n =head;
				SingleLinkedListNode m;
				for(int i=0;i<index-1;i++) {
					n=n.getNext();
				}
				m=n.getNext();
				n.setNext(m.getNext());
				size--;
			}
			
		}
		
	}
	@Override
	public int size() {
		return this.size;
	}
	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if(fromIndex>size || fromIndex <0 || toIndex>size || toIndex<0 ) {
	    	NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
	    }
		else {
		int subSize=toIndex-fromIndex+1;
		SingleLinkedListNode node=head;
		for(int i=0;i<fromIndex;i++) {
			node=node.getNext();
		}
		SingleLinkedList newList=new SingleLinkedList();
		for(int i=0;i<subSize;i++) {
			newList.add(node.getElement());
			node=node.getNext();	
		}
		//newList.show();
		return newList;
		}
	}
	@Override
	public boolean contains(Object o) {
		boolean test =false;
		if (head!=null) {
			SingleLinkedListNode node = head;
			if (node.getElement() == o) {
				test = true;
			} else {
				for (int i = 1; i < this.size; i++) {
					node = node.getNext();
					if (node.getElement() == o) {
						test = true;
					}
				}
			}
			return test;
		}
		else
			return false;
	}
	public void show() {
		SingleLinkedListNode n = head;
		while(n.getNext()!=null) {
			System.out.println(n.getElement());
			n=n.getNext();
		}
		System.out.println(n.getElement());
		
	}

}
