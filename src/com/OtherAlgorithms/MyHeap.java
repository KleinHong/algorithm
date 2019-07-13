package com.OtherAlgorithms;
import java.util.Comparator;

public class MyHeap<K> {
	private Node<K> head;
	private Node<K> last;
	private long size;
	private Comparator<K> comp;

	public MyHeap(Comparator<K> comp) {
		head = null;
		last = null;
		size = 0;
		this.comp = comp;
	}

	public K getHead() {
		return head == null ? null : head.value;
	}

	public long getSize() {
		return size;
	}

	public void add(K value) {
		Node<K> cur = new Node<K>(value);
		if (size == 0) {
			head = cur;
			last = cur;
			size++;
			return;
		}
		Node<K> node = last;
		Node<K> parent = node.parent;
		while (parent != null && node != parent.left) {
			node = parent;
			parent = node.parent;
		}
		Node<K> nodeToAdd = null;
		if (parent == null) {
			nodeToAdd = mostleft(head);
			nodeToAdd.left = cur;
			cur.parent = nodeToAdd;

		} else if (parent.right == null) {
			parent.right = cur;
			cur.parent = parent;
		} else {

			nodeToAdd = mostleft(parent.right);
			nodeToAdd.left = cur;
			cur.parent = nodeToAdd;
		}
		size++;
		last = cur;
		helpInsertHeap();
	}

	private void helpInsertHeap() {
		// TODO Auto-generated method stub
		Node<K> node = last;
		Node<K> parent = node.parent;
		if (parent != null && comp.compare(node.value, parent.value) < 0) {
			last = parent;
		}
		while (parent != null && comp.compare(node.value, parent.value) < 0) {
			swapNode(node, parent);
			parent = node.parent;
		}
		while (head.parent != null) {
			head = head.parent;// 防止头结点被交换过
		}

	}

	/**
	 * 交换节点需要使用五个节点变量，用来保存各个子节点和父节点 交换顺序是先头后左再右
	 * 
	 * @param node
	 * @param parent
	 */
	private void swapNode(Node<K> node, Node<K> parent) {
		// TODO Auto-generated method stub
		if (node == null || parent == null) {
			return;
		}
		Node<K> p1 = parent.parent;
		Node<K> l1 = parent.left;
		Node<K> r1 = parent.right;
		Node<K> l2 = node.left;
		Node<K> r2 = node.right;
		node.parent = p1;
		if (p1 != null) {
			if (parent == p1.left) {
				p1.left = node;
			} else {
				p1.right = node;
			}
		}
		parent.parent = node;
		if (l2 != null) {
			l2.parent = parent;
		}
		if (r2 != null) {
			r2.parent = parent;
		}
		
		if (node == parent.left) {
			node.left = parent;
			node.right = r1;
			if (r1 != null) {
				r1.parent = node;
			}
		} else {
			node.left = l1;
			node.right = parent;
			
			if (l1 != null) {
				l1.parent = node;
			}
		}

		parent.left = l2;
		parent.right = r2;

	}

	private Node<K> mostleft(Node<K> head1) {

		// TODO Auto-generated method stub
		while (head1.left != null) {
			head1 = head1.left;
		}
		return head1;
	}

	public K popHead() {
		if (size == 0) {
			return null;
		}
		Node<K> res = head;
		if (size == 1) {
			head = null;
			last = null;
			size--;
			return res.value;
		}
		Node<K> oldLast = popLastAndSetLast();
		oldLast.parent=null;//不弄掉的话会导致循环链表出现
		if (size == 1) {
			head = oldLast;
			last = oldLast;
			return res.value;
		}

		Node<K> hl = res.left;
		Node<K> hr = res.right;
		oldLast.left = hl;
		if (hl != null) {
			hl.parent = oldLast;
		}
		oldLast.right = hr;
		if (hr != null) {
			hr.parent = oldLast;
		}
		res.left = null;
		res.right = null;
		head = oldLast;
		adjust(oldLast);
		return res.value;

	}

	private void adjust(Node<K> node) {
		// TODO Auto-generated method stub

		Node<K> left = node.left;
		Node<K> right = node.right;
		Node<K> most = node;
		while (left != null) {
			if (left != null && comp.compare(left.value, most.value) < 0) {
				most = left;
			}
			if (right != null && comp.compare(right.value, most.value) < 0) {
				most = right;
			}
			if (most != node) {
				swapNode(most, node);
			} else {
				break;
			}
			left = node.left;
			right = node.right;
			most = node;
		}
		// 防止尾结点被替换
		if (node.parent == last) {
			last = node;
		}
		// 找到头结点
		while (node.parent != null) {
			node = node.parent;
		}
		head = node;

	}

	private Node<K> popLastAndSetLast() {
		// TODO Auto-generated method stub

		Node<K> node = last;

		Node<K> parent = node.parent;
		while (parent != null && node != parent.right) {
			node = parent;
			parent = parent.parent;
		}
		if (parent == null) {
			node = last;
			parent = node.parent;
			if (node == parent.left) {
				parent.left = null;

			} else {
				parent.right = null;
			}
			last = mostright(head);
		} else {
			Node<K> newNode = mostright(parent.left);
			node = last;
			parent = node.parent;
			node.parent = null;
			if (node == parent.left) {
				parent.left = null;

			} else {
				parent.right = null;
			}
			last = newNode;
		}
		size--;
		return node;

	}

	private Node<K> mostright(Node<K> head2) {
		// TODO Auto-generated method stub
		while (head2.right != null) {
			head2 = head2.right;
		}
		return head2;

	}
	
	
	
	public void printTreeByInOrder1(Node<K> node) {
		if(node==null) {
			return;
		}
		System.out.print(node.value+" ");
		printTreeByInOrder1(node.left);
		
		printTreeByInOrder1(node.right);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Comparator<Node<Integer>> comp=new Comparator<Node<Integer>>() {
//			public int compare(Node<Integer> n1,Node<Integer> n2) {
//				if(n1.value<n2.value) {
//					return -1;
//				}
//				else if(n1.value==n2.value){
//					return 0;
//				}
//				else {
//					return 1;
//				}
//			}
//		};

		MyHeap<Integer> mh = new MyHeap<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}

		});

		System.out.println(mh.getSize());
		for (int i = 0; i < 10; i++) {
			mh.add((int)(Math.random()*100));
		}
		
		

//		System.out.println(mh.getSize());
//		System.out.println(mh.getHead());
		while (mh.size != 0) {
			mh.printTreeByInOrder1(mh.head);
			System.out.println();
			mh.popHead();
		}

	}

}
