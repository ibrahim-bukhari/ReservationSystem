import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BookingManager {

	
	
	private static HashMap<Date, ArrayList<Table>> bookings = new HashMap<Date, ArrayList<Table>>();
	private static ArrayList<Table> booked = new ArrayList<Table>();
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Table t1 = new Table(5);
		Table t2 = new Table(15);
		Table t3 = new Table(10);
		
		Customer c1 = new Customer("Bruce", "Banner", "111");
		Customer c2 = new Customer("Tony", "Stark", "222");
		Customer c3 = new Customer("Peter", "Parker", "222");
		
		/*
		DateFormat format = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm");
		String date1 = "Monday, Oct 10, 2016 18:45";
		String date2 = "Friday, Jun 7, 2013 12:10";
		String date3 = "Friday, Jun 8, 2014 12:10";
		*/
		
		
		DateFormat format = new SimpleDateFormat("HH:mm");
		String date1 = "18:30";
		String date2 = "19:30";
		String date3 = "21:30";
		
		
		Date d1 = format.parse(date1);
		Date d2 = format.parse(date2);
		Date d3 = format.parse(date3);
		
		reserveTable(d1, t1, c1, 30, 5, date1);
		reserveTable(d2, t2, c2, 30, 5, date2);
		reserveTable(d1, t1, c1, 30, 5, date1);
		reserveTable(d2, t2, c2, 30, 5, date2);
		reserveTable(d3, t2, c2, 30, 5, date3);
		
		//cancelTable(d1, t1, c1, 30, 5);
		//cancelTable(d3, t1, c1, 30, 5);
		
		//printAvailableSlots(t1);
		//printAvailableSlots(t2);
		isAvailable(date1, t1);
		isAvailable(date2, t1);
		isAvailable(date3, t2);
		isAvailable(date3, t1);
		
	}
	
	//Reserve Table
	private static void reserveTable(Date d, Table t, Customer c, int duration, int numPeople, String time) {
		if(bookings.containsKey(d)) {
			ArrayList<Table> tList = bookings.get(d);
			if(tList.contains(t)) {
				System.out.println("table already reserved");
			}
		}
		else {
			booked.add(t);
			bookings.put(d, booked);
			Booking b = new Booking(d, duration, numPeople, t, c);
			t.updateSlotAvailability(time, false);
			System.out.println("Adding reservation");
		}	
	}
	
	//Cancel Table
	//Close Reservation/table
	private static void cancelTable(Date d, Table t, Customer c, int duration, int numPeople) {
		if(bookings.containsKey(d)) {
			ArrayList<Table> tList = bookings.get(d);
			if(tList.contains(t)) {
				System.out.println("Cancelling reservation");
				booked.remove(t);
				bookings.remove(d, booked);
				t.updateSlotAvailability(d.toString(), true);
			}
			else {
				System.out.println("No booking found");
			}
			
		}
		else {
			System.out.println("No booking found");
		}	
	}
	
	//todo
	//update table/reservation
	private static void updateTable(Date d, Table t, Customer c, int duration, int numPeople) {
		if(bookings.containsKey(d)) {
			ArrayList<Table> tList = bookings.get(d);
			if(tList.contains(t)) {
				System.out.println("Cancelling reservation");
				booked.remove(t);
				bookings.remove(d, booked);
			}
			else {
				System.out.println("No booking found");
			}
			
		}
		else {
			System.out.println("No booking found");
		}	
	}
	
	
	//QuerySlot
	private static boolean isAvailable(String d, Table t) {
		boolean val = t.getAvailableSlots().get(d.toString());
		if(val) {
			System.out.println("Table availavle for that time slot");
		}
		else {
			System.out.println("Slot is not free for this table");
		}
		return val; 
	}
	
	//GetAvailableSlots - This will show enumerated list of all the tables with timestamp of given date. It depicts free/occupied slot.
	private static void printAvailableSlots(Table t) {
		for (Map.Entry<String, Boolean> entry : t.getAvailableSlots().entrySet()) {
		    String key = entry.getKey();
		    Boolean value = entry.getValue();
		    System.out.println(key + "-" + value);
		}
	}
	
	//ContactConsumer
	

}
