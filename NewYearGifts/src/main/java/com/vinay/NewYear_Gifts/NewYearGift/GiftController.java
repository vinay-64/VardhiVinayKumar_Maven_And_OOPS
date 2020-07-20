package com.vinay.NewYear_Gifts.NewYearGift;

import java.util.ArrayList;
import java.util.Collections;

import com.vinay.NewYear_Gifts.NewYearGift.Sweets.Sweet;

public class GiftController {
	private NewYearGift newYearGift;

    private ArrayList<Sweet> items;

    private double totalWeight = 0;

    private int counter = 1;

    private final static int START_OF_COUNT = 1;

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public GiftController()  {
        items = new ArrayList<Sweet>();
        newYearGift = new NewYearGift();
        totalWeight = 0;
    }

    private void printTitle(String msg) {
        System.out.printf("%-38s\n\n", msg);
        System.out.printf("%-3s%-20s %5s %10s\n", "#", "Name", "Sugar", "Weight");
        System.out.printf("%-3s%-20s %5s %10s\n", "-", "----", "-----", "------");
    }

    private void print(Sweet item) {
    	System.out.printf("%-3d%-20.15s %5.2f %10.2f\n", counter++, item
                .getClass().getSimpleName(), item.getSugarLevel(), item
                .getWeight());
        totalWeight += item.getWeight();
    }

    private void printTotalWeight() {
    	System.out.printf("%-23s %5s %10s\n", "", "", "------");
    	System.out.printf("%-3s%-20s %5s %10.2f\n", "", "Total Weight", "",
                totalWeight);
    }

    private void printSpace() {
    	System.out.printf("\n%-38s\n\n\n",
                "========================================");
    }

    public void generateGift(int nTimes) {
        items = newYearGift.generate(nTimes);
        showParsedData();
    }

    private void printGift() {
        for (Sweet item : items) {
            print(item);
        }
    }

    private void printGift(ArrayList<Sweet> sweets) {
        for (Sweet sweet : sweets) {
            print(sweet);
        }
    }

    public void showSortedBySugar() {
        Collections.sort(items, newYearGift.getSugarLevelComparator());
        printTitle("New Year's Gift by sorted Sugar level:");
        printGift();
        printTotalWeight();
        printSpace();
        setCountersToStart();
    }

    public void showSortedByWeight() {
        Collections.sort(items, newYearGift.getWeightComparator());
        printTitle("New Year's Gift by sorted Weight:");
        printGift(items);
        printTotalWeight();
        printSpace();
        setCountersToStart();
    }

    public void showParsedData() {
        printTitle("\n\nNew Year's Gift (list of contents):");
        for (Sweet sweet : items) {
            print(sweet);
        }
        printTotalWeight();
        printSpace();
        setCountersToStart();
        showSortedBySugar();
        showSortedByWeight();
    }

    private void setCountersToStart() {
        setCounter(START_OF_COUNT);
        setTotalWeight(0);
    }

}
