package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locationsMap = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        locationsMap.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locationsMap.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locationsMap.put(2, new Location(2, "You are at the top of a hill"));
        locationsMap.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locationsMap.put(4, new Location(4, "You are in valley beside a stream"));
        locationsMap.put(5, new Location(5, "You are in the forest"));


        // "Q" => 0 added to the constructor of location
        locationsMap.get(1).addExit("W", 2);
        locationsMap.get(1).addExit("E", 3);
        locationsMap.get(1).addExit("S", 4);
        locationsMap.get(1).addExit("N", 5);
//        locationsMap.get(1).addExit("Q", 0);

        locationsMap.get(2).addExit("N", 5);
//        locationsMap.get(2).addExit("Q", 0);

        locationsMap.get(3).addExit("W", 1);
//        locationsMap.get(3).addExit("Q", 0);

        locationsMap.get(4).addExit("N", 1);
        locationsMap.get(4).addExit("W", 2);
//        locationsMap.get(4).addExit("Q", 0);

        locationsMap.get(5).addExit("S", 1);
        locationsMap.get(5).addExit("W", 2);
//        locationsMap.get(5).addExit("Q", 0);


        int loc = 1;
        while (true) {
            System.out.println(locationsMap.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locationsMap.get(loc).getExits();
            System.out.println("Available exits are: ");
            for (String exit : exits.keySet()) {
                System.out.println(exit + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
           /* if (!locationsMap.containsKey(loc)) {
                System.out.println("You cannot go in that direction");
            }*/
        }

    }
}
