package com.vinay.NewYear_Gifts.NewYearGift;

import java.util.ArrayList;
import java.util.Comparator;

import com.vinay.NewYear_Gifts.NewYearGift.Sweets.Sweet;
import com.vinay.NewYear_Gifts.NewYearGift.Sweets.SweetsGenerator;

public class NewYearGift {
	private SweetsGenerator generator;

    private ArrayList<Sweet> newYearsList;

    private static SugarLevelComparator sugarComparator = new SugarLevelComparator();

    private static WeightComparator weightComparator = new WeightComparator();

    public SugarLevelComparator getSugarLevelComparator() {
        return sugarComparator;
    }

    public WeightComparator getWeightComparator() {
        return weightComparator;
    }

    public NewYearGift() {
        generator = new SweetsGenerator();
        newYearsList = new ArrayList<Sweet>();
    }

    public ArrayList<Sweet> generate(int times) {

        for (int i = 0; i < times; i++) {
        	System.out.printf("\nEntering sugar and weight : ");
            newYearsList.add(generator.next());
        }
        return newYearsList;
    }

    private static class SugarLevelComparator implements Comparator<Sweet> {

        public int compare(Sweet sweetsOne, Sweet sweetsTwo) {
            return (sweetsOne.getSugarLevel() < sweetsTwo.getSugarLevel() ? -1
                    : (sweetsOne.getSugarLevel() == sweetsTwo.getSugarLevel() ? 0 : 1));
        }

    }

    private static class WeightComparator implements Comparator<Sweet> {

        public int compare(Sweet sweetsOne, Sweet sweetsTwo) {
            return (sweetsOne.getWeight() < sweetsTwo.getWeight() ? -1
                    : (sweetsOne.getWeight() == sweetsTwo.getWeight() ? 0 : 1));
        }

    }
}
