package queue;

public class PriorityQueue implements IPriorityQueue {
	public static class PriorityQueueNode{
		private Object element;
		private int key;
		private PriorityQueueNode next, prev;
		public PriorityQueueNode(){
			element = null;
			prev = null;
			next = null;
			key=0;
		}
		public PriorityQueueNode(Object e,int i){
			element = e;
			prev = null;
			next = null;
			key=i;

		}
		public PriorityQueueNode(Object e, PriorityQueueNode p, PriorityQueueNode n,int i) {
			element = e;
			prev = p;
			next = n;
			key =i;
		}
		/** Returns the key of this node */
		public int getKey() {
			return key;
		}
		/** Sets the key value of key of this node */
		public void setKey(int i) {
			key = i;
		}
		/** Returns the element of this node */
		public Object getElement() {
			return element;
		}
		/** Returns the previous node of this node */
		public PriorityQueueNode getPrev() {
			return prev;
		}
		/** Returns the next node of this node */
		public PriorityQueueNode getNext() {
			return next;
		}
		/** Sets the element of this node */
		public void setElement(Object newElem) {
			element = newElem;
		}
		/** Sets the previous node of this node */
		public void setPrev(PriorityQueueNode newPrev) {
			prev = newPrev;
		}
		/** Sets the next node of this node */
		public void setNext(PriorityQueueNode newNext) {
			next = newNext;
		}
	}
////////////////////////////////////////////the priority queue/////////////////////////////////////////////
	private PriorityQueueNode Head = new PriorityQueueNode(null,0);
	private int Size;
	public PriorityQueue(){
		Head = null;
		Size =0;
	}

	/**
	 * Inserts an item with priority key.
	 * key "1" is the highest priority.
	 */
	@Override
	public void insert(Object item, int key) {
		PriorityQueueNode new_node=new PriorityQueueNode(item,key);
		if(Head==null)
			Head=new_node;
		else if(Head.getKey()>key) {
			new_node.setNext(Head);
			Head.setPrev(new_node);
			Head=new_node;
		}
		else {
			PriorityQueueNode check=Head;
			while(check!=null) {
				if(check.getKey()>key) {
					PriorityQueueNode temp=check.getPrev();
					check.setPrev(new_node);
					new_node.setNext(check);
					new_node.setPrev(temp);
					temp.setNext(new_node);
					break;
				}
				else if(check.getNext()==null) {
					if(check.getKey()>key) {
						PriorityQueueNode temp=check.getPrev();
						check.setPrev(new_node);
						new_node.setNext(check);
						new_node.setPrev(temp);
						temp.setNext(new_node);
					}
					else {
						check.setNext(new_node);
						new_node.setPrev(check);
					}
					break;
				}
				else
					check=check.getNext();
					
			}
		}
		Size++;
			
	}

	/**
	 * Removes the object with the highest priority.
	 */
	@Override
	public Object removeMin()throws RuntimeException {
		if(Size==0)
			throw new RuntimeException(" empty queue");
		Object temp=Head.getElement();
		Head=Head.getNext();
		if(Head!=null)
			Head.setPrev(null);
		Size--;
		return temp;
	}

	/**
	 * Return the object with the highest priority.
	 */
	@Override
	public Object min()throws RuntimeException {
		if(Size==0)
			throw new RuntimeException(" empty queue"); 
		return Head.getElement();
	}

	/**
	 * Tests if this queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		return (Size==0);
	}

	/**
	 * Returns the number of elements in the queue
	 */
	@Override
	public int size() {
		return Size;
	}
}
