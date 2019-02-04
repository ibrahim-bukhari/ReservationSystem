import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Booking {
	private int id;
	private Date bookingTime;
	int duration;
	Table t;
	Customer c;
	
	private static int counter = 1;
	
	Booking(Date bookingTime, int duration, int numOfPeople, Table t, Customer c) {
		//this.t = t;
		/*
		if(bookings.containsKey(bookingTime)) {
			ArrayList<Integer> tList = bookings.get(bookingTime);
			if(tList.contains(tableId)) {
				System.out.println("Table " + tableId + " already booked for this time slot. Try another");
				return;
			}
		}    
		*/                                                                                                                                                                                                                               
		setId();
		this.bookingTime = bookingTime;
		this.duration = duration;
		this.c = c;
		this.t = t;
		
	}
	
	public Date getBookingTime() {
		return this.bookingTime;
	}
	public void setBookingTime(Date time) {
		this.bookingTime = time;
	}
	
	public int getDuration() {
		return this.duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Table getReservationTable() {
		return this.t;
	}
	public void setReservationTable(Table t) {
		this.t = t;
	}
	
	public Customer getReservationCustomer() {
		return this.c;
	}
	public void setReservationCustomer(Customer c) {
		this.c = c;
	}
	
	public int getId() {
		return this.id;
	}
	private void setId() {
		this.id = counter++;
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(id);
		b.append(". ");
		b.append(bookingTime);
		b.append(" for ");
		b.append(duration);
		b.append(" at Table ");
		b.append(t.getId());
		b.append(" for Customer ");
		b.append(c.getId());
		return b.toString();
	}
}
