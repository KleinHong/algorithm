package com.OtherAlgorithms;
class Node<K>{
	public K value;
	public Node<K> left;
	public Node<K> right;
	public Node<K> parent;
	public Node(K value){
		this.value=value;
	}
}