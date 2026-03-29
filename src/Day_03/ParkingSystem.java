package Day_03;

/*
Problem: Design Parking System
Day: 03

Description:
Design a parking system that can store different types of cars:
1 → Big
2 → Medium
3 → Small

Each type has limited parking slots.

Methods:

ParkingSystem(int big, int medium, int small)
→ Initializes parking slots.

boolean addCar(int carType)
→ Parks the car if space is available.

Approach:
Use an integer array to track remaining slots.

Index Mapping:
spaces[1] → Big
spaces[2] → Medium
spaces[3] → Small

Time Complexity:
addCar() → O(1)

Space Complexity:
O(1)

Concepts:
- Class Design
- Array indexing
- Object-Oriented Programming (OOP)

*/

class ParkingSystem {

    // spaces[1] = big
    // spaces[2] = medium
    // spaces[3] = small
    private int[] spaces;

    // Constructor
    public ParkingSystem(int big, int medium, int small) {

        spaces = new int[4]; // index 0 unused

        spaces[1] = big;
        spaces[2] = medium;
        spaces[3] = small;
    }

    // Add car to parking
    public boolean addCar(int carType) {

        // Check if space available
        if (spaces[carType] > 0) {

            spaces[carType]--; // occupy slot

            return true;
        }

        return false; // no space left
    }

    public static void main(String[] args) {

        ParkingSystem ps = new ParkingSystem(1, 1, 0);

        System.out.println(ps.addCar(1)); // true
        System.out.println(ps.addCar(2)); // true
        System.out.println(ps.addCar(3)); // false
        System.out.println(ps.addCar(1)); // false

    }
}