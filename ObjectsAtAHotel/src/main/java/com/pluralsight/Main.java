package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        Room room1 = new Room(2, 149.99, false, false);
        System.out.println("Room Beds: " + room1.getNumberOfBeds());
        System.out.println("Room Price: $" + room1.getPrice());
        System.out.println("Occupied? " + room1.isOccupied());
        System.out.println("Dirty? " + room1.isDirty());
        System.out.println("Available? " + room1.isAvailable());

        System.out.println();

        Reservation reservation1 = new Reservation("king", 3, true);
        System.out.println("Room Type: " + reservation1.getRoomType());
        System.out.println("Is Weekend: " + reservation1.isWeekend());
        System.out.println("Number of Nights: " + reservation1.getNumberOfNights());
        System.out.println("Price per Night: $" + reservation1.getPrice());
        System.out.println("Total Reservation: $" + reservation1.getReservationTotal());

        System.out.println();

        Employee emp1 = new Employee("1iy45fx", "Mickey Teke", "Kitchen", 20.0, 52);
        System.out.println("Employee: " + emp1.getName());
        System.out.println("Department: " + emp1.getDepartment());
        System.out.println("Hours Worked: " + emp1.getHoursWorked());
        System.out.println("Regular Hours: " + emp1.getRegularHours());
        System.out.println("Overtime Hours: " + emp1.getOvertimeHours());
        System.out.println("Total Pay: $" + emp1.getTotalPay());

        Room room101 = new Room(2, 149.99, false, false);
        System.out.println("Initial room status:");
        System.out.println("Available: " + room101.isAvailable());
        System.out.println("\nTrying to check in...");
        room101.checkIn();
        System.out.println("Occupied: " + room101.isOccupied());
        System.out.println("Dirty: " + room101.isDirty());
        System.out.println("Available: " + room101.isAvailable());
        System.out.println("\nChecking out...");
        room101.checkOut();
        System.out.println("Occupied: " + room101.isOccupied());
        System.out.println("Dirty: " + room101.isDirty());
        System.out.println("\nCleaning the room...");
        room101.cleanRoom();
        System.out.println("Dirty: " + room101.isDirty());
        System.out.println("Available: " + room101.isAvailable());


        Employee e = new Employee("1iy45fx", "Mickley Teke", "Kitchen", 20.0, 0);
        e.punchTimeCard(9.0);
        e.punchTimeCard(17.0);
    }

}