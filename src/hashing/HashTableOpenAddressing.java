package hashing;



public class HashTableOpenAddressing<K,V> {
	
private HashTableNode<K, V>[]tableNodes;
private int size;
public HashTableOpenAddressing(int capacity) {
	super();
this.size=0;
this.tableNodes=new HashTableNode[capacity];
}
public HashTableOpenAddressing() {
    this(5);
  }
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public int getIndex(int hash) {
	return hash%capacity();
}
private int capacity() {
	return tableNodes.length;
}
public void put(K key,V value) {
int hash=hash(key);	
int index=getIndex(hash);
int startIndex=index;
HashTableNode< K, V> hashTableNode;
while((hashTableNode=tableNodes[index])!=null) {
	if(hash==hashTableNode.hash&&hashTableNode.key.equals(key)) {
		tableNodes[index].value=value;
		return;
	}
	index=linearProbing(index);
	if(index==startIndex) {
		resize(capacity()*2);
		index=getIndex(hash);
		startIndex=index;
	}
}
}


//Search method
//i.o.w search an element in hash table
public V searchElement(K key) {
	int hash=hash(key);
	HashTableNode<K, V>hashTableNode;
	int index=getIndex(hash);
	int startIndex=index;
	while((hashTableNode=tableNodes[index])!=null) {
		if(hash==hashTableNode.hash&&hashTableNode.key.equals(key)) {
		return tableNodes[index].value;	
		}
		index=linearProbing(index);
		if(index==startIndex)return null;
	}
	printInnerVar();
	return null;
}
//Remove method
//I.O.W remove an element from hash table
public V remove(K key) {
	int hash=hash(key);
	int index=getIndex(hash);
	int startIndex=index;
	HashTableNode<K, V>hashTableNode;
	V oldVal=null;
	while((hashTableNode=tableNodes[index])!=null) {
		if(hash==hashTableNode.hash&&hashTableNode.key.equals(key)) {
		oldVal=tableNodes[index].value	;
		tableNodes[index]=null;
		size--;
		}
		index=linearProbing(index);
		if(index==startIndex) break;
	}
	if(size==capacity()/4&&capacity()/2!=0) {
		resize(capacity()/2);
	}
	printInnerVar();
	return oldVal;
}
private void printInnerVar() {
	System.out.println("Capacity : "+capacity()+" , Size :"+size);
}
private void resize(int newCapacity) {
    HashTableNode<K, V>[] oldTab = tableNodes;
    tableNodes = new HashTableNode[newCapacity];
    size = 0;
    for (HashTableNode<K, V> hashNode : oldTab) {
      if (hashNode != null) {
        put(hashNode.key, hashNode.value);
      }
    }
}

//Quadratic probing
public int quadraticProbing(int index) {
	return((index*index))%this.capacity();
}
//Double Hashing
public int hashing_double(int index) {
	return(2*index)%this.capacity();
}
//Linear probing
private int linearProbing(int index) {
	return (index+1)%capacity();
}
public int hash(K key) {
return key==null ? 0 : key.hashCode();	
}
public void print() {
    for (int i = 0; i < this.capacity(); i++) {
      System.out.print("(" + i + ") : ");
      if (this.tableNodes[i] == null) {
        System.out.println("null");
      } else {
        System.out.println(this.tableNodes[i].key.toString() + " : " + this.tableNodes[i].value.toString());
      }
    }
  }
static class HashTableNode<K,V> {
int hash;
K key;
V value;

public HashTableNode(int hash, K key, V value) {
	super();
	this.hash = hash;
	this.key = key;
	this.value = value;
}

}

}
