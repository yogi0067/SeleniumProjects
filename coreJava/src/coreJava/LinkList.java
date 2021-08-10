package coreJava;

public class LinkList {
	Node Head;
	LinkList(){
		Head=null;
	}
	
	 static class Node
	{
		int data;
		Node next=null;
		
		Node(int value)
		{
			data=value;
			next=null;
		}
	}
	 
	public static LinkList insetLinklist(LinkList list, int data)
	{
		
		Node newNode=new Node(data);
		newNode.next=null;
		
		
		if (list.Head==null)
		{
			list.Head=newNode;
		}
		else
		{
			Node last= list.Head;
			//traverse to last
			
			if(last.next!=null)
			{
				last=last.next;
			}
			last.next=newNode;
		}
		return list;		
		
		
	}
	
	public static void printlinklist(LinkList list) 
	{
		Node travesal= list.Head;
		while(travesal!=null)
		{
			System.out.print(travesal.data + " ");
			travesal=travesal.next;
		}
		
	}
	public static void main(String[] args) {
		LinkList list= new LinkList();
		
		list= insetLinklist(list, 1);
		list= insetLinklist(list, 2);
		list= insetLinklist(list, 5);
		list= insetLinklist(list, 6);
		list= insetLinklist(list, 7);
		
		printlinklist(list);
		
	}
	

}
