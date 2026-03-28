package exp1;

import java.util.Scanner;
class Ticket{
	String passanger ;
	int seatno;
	Ticket(String P, int S)
	{
		this.passanger=P;
		this.seatno=S;
	}
}
class sll{
	private sll head;
	sll next;
	Ticket ticket;
	sll(Ticket t){
		ticket = t;
		next = null;
	}
}
class linkedlist2{
	sll cnode,head;
		public void add_ticket(Ticket t)
		{
			sll newnode = new sll(t);																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			
			if(head == null)
			{
				head = newnode;
			}
			else {
				sll cnode = head;
				while(cnode.next!=null)
				{
					cnode = cnode.next;
				}
				cnode.next = newnode;
			}
		}
		
		public void remove_ticket(int seatno)
		{
			if(head==null)System.out.println("list is empty");
			else {
				sll cnode = head;
				if(cnode.ticket.seatno==seatno)
				{
					System.out.println("deleted "+ head.ticket.passanger);
					head = head.next;
				}
				else {
					while(cnode!=null&& cnode.next.ticket.seatno != seatno)
					{
						cnode = cnode.next;
					}	
					if(cnode==null)
						System.out.println("seat number not found");
					else {
						System.out.println("deleted "+cnode.ticket.passanger);
						cnode.next = cnode.next.next;
					}
				}
			}
			
		}
		 
		public void displayticktes()
		{
			if(head == null)
			{
				System.out.println("No tickets booked ");
			}
			else {
			sll cnode = head;
			System.out.println("booked tickets: ");
			while(cnode!=null)
			{
				
				System.out.println(cnode.ticket.seatno+"-->"+cnode.ticket.passanger);
				cnode = cnode.next;
			}
			}
			
		}
		public boolean isbooked(int seat)
		{
			sll cnode = head;
			
			while(cnode!=null)
			{
				if(cnode.ticket.seatno==seat)
				{
					
					return true;
					
				}
				else
				{
					cnode = cnode.next;
				}
			
			}
			
				return false;
		}
		public int count()
		{
			int count =0;
			cnode = head;
			while(cnode!=null)
			{
				cnode = cnode.next;
				count++;
			}
			return count;
		}
}
class ticketstk{
	private Ticket[] stack;
	private int top;
	private int capacity;
	ticketstk(int no_ticktes)
	{
		capacity = no_ticktes;
		stack = new Ticket[capacity];
		top = -1;
	}
	boolean isEmpty()
	{
		return top==-1;
	}
	boolean isFull(){
		return top==capacity-1;
	}
	public void push(Ticket t)
	{
		if(!isFull())
		stack[++top]=t;
	}
	public Ticket pop()
	{
		if(!isEmpty())
			return stack[top--];
		else
			return null;
	}
	public Ticket peek()
	{
		return stack[top];
	}
	void display()
	{
		for(int i = 0;i<capacity;i++)
		{
			if(stack[i]!=null)
			{
				System.out.println(i);
			}
		}
	}
}
public class rough {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalseats = 40;
		linkedlist2 llobj = new linkedlist2();
		ticketstk stackobj = new ticketstk(totalseats);
		boolean exit = true;
		 while (exit) {
	            System.out.println("\n1. Book Ticket");
	            System.out.println("2. Cancel Last Ticket");
	            System.out.println("3. Cancel by Seat Number");
	            System.out.println("4. View Booked Tickets");
	            System.out.println("5. View Available Seats");
	            System.out.println("6. Exit");
	            System.out.print("Choose an option: ");
	            int choice = sc.nextInt();
	            switch(choice) {
	            case 1:
	            	System.out.println("Enter the name ");
	            	String name = sc.next();
	            	System.out.println("Enter the seat u want to book ");
	            	int seat = sc.nextInt();
	            	if(seat <1|| seat>40)
	            	{
	            		System.out.println("Invalid Choice!");
	            	}
	            	else if(llobj.isbooked(seat))
	            	{
	            		System.out.println("Seat already book");
	            	}
	            	else {
	            	Ticket t = new Ticket(name,seat);
	            	llobj.add_ticket(t);
	            	System.out.println("Ticket booked suyccesfully ..... : )");
	            	}
	            	break;
	            	
	            case 2:
	            	Ticket t = stackobj.pop();
	            	if(t!=null)
	            		System.out.println(t.seatno+"-->"+t.passanger);
	            	else
	            		System.out.println("no ticket booked at las");
	            	break;
	            case 3:
	            	System.out.println("Enter the seat u want to cancel");
	            	int canseat = sc.nextInt();
	            	llobj.remove_ticket(canseat);
	            	break;
	            case 4:
	            	llobj.displayticktes();
	            	break;
	            case 5:
	            	System.out.println("Available seats are "+(totalseats-llobj.count()));
	            	break;
	            case 6:
	            	exit = false;
	            	break;
	            	
	            }
	            
		 }
		 System.out.println("Thank you .... : )");
				
}

}
