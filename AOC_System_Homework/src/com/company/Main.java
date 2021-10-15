package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static int crossBridge(int numberOfPeople, List<Integer> speedsOfCrossingTheBridge) {

    if (numberOfPeople < 3) {
      return speedsOfCrossingTheBridge.get(numberOfPeople - 1);
    } else if (numberOfPeople == 3) {
      return speedsOfCrossingTheBridge.get(0) + speedsOfCrossingTheBridge.get(1)
          + speedsOfCrossingTheBridge.get(2);
    } else {
      int tempSpeed1 =
          speedsOfCrossingTheBridge.get(1) + speedsOfCrossingTheBridge.get(0)
              + speedsOfCrossingTheBridge.get(numberOfPeople - 1) + speedsOfCrossingTheBridge
              .get(1);
      int tempSpeed2 =
          speedsOfCrossingTheBridge.get(numberOfPeople - 1) + speedsOfCrossingTheBridge.get(0)
              + speedsOfCrossingTheBridge.get(numberOfPeople - 2) + speedsOfCrossingTheBridge
              .get(0);

      if (tempSpeed1 < tempSpeed2) {
        return tempSpeed1 + crossBridge(numberOfPeople - 2, speedsOfCrossingTheBridge);
      } else if (tempSpeed2 < tempSpeed1) {
        return tempSpeed2 + crossBridge(numberOfPeople - 2, speedsOfCrossingTheBridge);
      } else {
        return tempSpeed2 + crossBridge(numberOfPeople - 2, speedsOfCrossingTheBridge);
      }
    }
  }


  public static void main(String[] args) {

    int numberOfPeople = 4;
    List<Integer> speedsOfCrossingTheBridge = Arrays.asList(10, 5, 2, 1);
    speedsOfCrossingTheBridge = speedsOfCrossingTheBridge.stream().sorted()
        .collect(Collectors.toList());
    System.out.println(crossBridge(numberOfPeople, speedsOfCrossingTheBridge));
  }
}
