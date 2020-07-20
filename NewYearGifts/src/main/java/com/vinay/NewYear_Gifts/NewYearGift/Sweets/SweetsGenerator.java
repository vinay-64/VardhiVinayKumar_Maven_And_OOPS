package com.vinay.NewYear_Gifts.NewYearGift.Sweets;

import java.util.Iterator;
import java.util.Random;

public class SweetsGenerator implements Generator<Sweet>, Iterable<Sweet> {
	private static Random rand = new Random();

    private static final int SUGAR_MIN = 20;

    private static final int SUGAR_MAX = 80;

    private static final int WEIGHT_MIN = 50;

    private static final int WEIGHT_MAX = 200;
    
    private int size = 0;

    private Sweet[] instances = {new DairyMilk(), new MilkChocolate(),
            new Halva(), new GulabJamun()
    };

    public Sweet next() {
    	try {
    		Sweet current = (Sweet)instances[rand.nextInt(instances.length)].clone();
    		double sugarParam = randomSugarLevel();
            double weightParam = randomWeight();
            current.setSugarLevel(sugarParam);
            current.setWeight(weightParam);
            System.out.println(sugarParam+"  "+weightParam);
            return  current;
    	}catch(CloneNotSupportedException c){}  
    	
    	return  null;
    }


    private double randomWeight() {
        return WEIGHT_MIN + (Math.random() * ((WEIGHT_MAX - WEIGHT_MIN) + 1));
    }


    private double randomSugarLevel() {
        return SUGAR_MIN + (Math.random() * ((SUGAR_MAX - SUGAR_MIN) + 1));
    }

    class SweetsIterator implements Iterator<Sweet> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Sweet next() {
            count--;
            return SweetsGenerator.this.next();
        }

    }

    ;

    public Iterator<Sweet> iterator() {
        return new SweetsIterator();
    }

}
