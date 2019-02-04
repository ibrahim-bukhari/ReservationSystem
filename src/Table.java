import java.util.ArrayList;
import java.util.HashMap;

public class Table {
	private int id;
	private int capacity;
	private boolean booked;
	HashMap<String, Boolean> availableSlots;
	
	private static int counter = 1;
	
	Table(int capacity) {
		setId();
		this.capacity = capacity;
		this.booked = false;
		availableSlots = new HashMap<String, Boolean>();
		availableSlots.put("17:30", true);
		availableSlots.put("18:30", true);
		availableSlots.put("19:30", true);
		availableSlots.put("20:30", true);
		availableSlots.put("21:30", true);
		
	}

	public int getCapacity() {
		return this.capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean getBooked() {
		return this.booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	public int getId() {
		return this.id;
	}
	private void setId() {
		this.id = counter++;
	}
	
	public HashMap<String, Boolean> getAvailableSlots() {
		return this.availableSlots;
	}
	
	public void updateSlotAvailability(String slot, boolean available) {
		availableSlots.put(slot, available);
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(id);
		b.append(". ");
		b.append(capacity);
		b.append(" people ");
		b.append(booked ? "Not available" : "Available" );
		return b.toString();
	}
}
