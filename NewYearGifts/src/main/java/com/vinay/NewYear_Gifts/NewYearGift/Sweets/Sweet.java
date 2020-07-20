package com.vinay.NewYear_Gifts.NewYearGift.Sweets;

public abstract class Sweet implements Cloneable{
	private double sugarLevel;

    private double weight;
    
    public Object clone()throws CloneNotSupportedException{  
    	return super.clone();  
    	} 

    public double getSugarLevel() {
        return sugarLevel;
    }

    public double getWeight() {
        return weight;
    }

    public void setSugarLevel(double sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
