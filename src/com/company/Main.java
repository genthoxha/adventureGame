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

        int loc = 1;
        while (true) {
            System.out.println(locationsMap.get(loc).getDescription());
            if (loc == 0) {
                break;
            }
            loc = scanner.nextInt();
            if (!locationsMap.containsKey(loc)) {
                System.out.println("You cannot go in that direction");
            }
        }

    }
}
