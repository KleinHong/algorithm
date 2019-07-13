/*
 * ��Ŀ��ʵ��һ��è�����У�ʵ��add��pollAll��pollDogAll�Ⱥ���
 * �ѵ㣺����è�����˳�����ε������У�è�����Ͳ�һ��
 * ˼·��ʹ��һ����������ʾè��������еı�ţ��������У����С���ȳ�����
 */
package com.StackAndQueue;
import java.util.LinkedList;
import java.util.Queue;

public class DogAndCat {
	
	private Queue<PetEnterQueue> dogq;
	private Queue<PetEnterQueue> catq;
	private long count;
	

	public DogAndCat() {
		// TODO Auto-generated constructor stub
		this.dogq=new LinkedList<>();
		this.catq=new LinkedList<>();
		this.count=0;
	}

	public void add(Pet pet){
		if(pet.getType().equals("dog")) {
			dogq.add(new PetEnterQueue(new Dog(),count++));
		}
		else if(pet.getType().equals("cat")){
			catq.add(new PetEnterQueue(new Cat(),count++));
		}
		else {
			throw new RuntimeException("Pet is not dog or cat");
		}

	}

	public Pet  pollAll() {
		if(!dogq.isEmpty() && !catq.isEmpty()) {
			if(dogq.peek().getCount()<catq.peek().getCount()) {
				return dogq.poll().getPet();
			}
			else {
				return catq.poll().getPet();
			}
		}
		else if(!dogq.isEmpty()) {
			return dogq.poll().getPet();
		}
		else if(!catq.isEmpty()) {
			return catq.poll().getPet();
		}
		else {
			throw new RuntimeException("è������Ϊ��");
		}
	}

	public Pet pollDog() {
		if(!dogq.isEmpty()) {
			return dogq.poll().getPet();
		}
		else {
			throw new RuntimeException("������Ϊ��");
		}

	}

	public Pet pollCat() {
		if(!catq.isEmpty()) {
			return catq.poll().getPet();
		}
		else {
			throw new RuntimeException("è����Ϊ��");
		}
	}

	public boolean isEmpty() {
		return dogq.isEmpty()&&catq.isEmpty();
	}

	public boolean isDogEmpty() {
		return dogq.isEmpty();

	}

	public boolean isCatEmpty() {
		return catq.isEmpty();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DogAndCat dac=new DogAndCat();
		for(int i=0;i<10;i++) {
			int c=(int) (Math.random()*100);
			if(c<50) {
				dac.add(new Dog());
			}
			else {
				dac.add(new Cat());
			}
		}
		while(!dac.isEmpty()) {
			System.out.print(dac.pollAll().getType()+" ");
		}

	}

}

class Pet {
	private String type;

	public Pet(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}

class Dog extends Pet {
	public Dog() {
		super("dog");
	}
}

class Cat extends Pet {
	public Cat() {
		super("cat");
	}
}

class PetEnterQueue {
	private Pet pet;
	private long count;

	public PetEnterQueue(Pet pet, long count) {
		this.pet = pet;
		this.count = count;
	}

	public Pet getPet() {
		return pet;
	}

	public long getCount() {
		return count;
	}

	public String getPetType() {
		return pet.getType();
	}
}
