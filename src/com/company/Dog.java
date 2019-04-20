package com.company;

public class Dog {

    // instance variables
    int dogID;
    String name;
    String breed;
    String sex;
    int age;
    int weight;
    boolean rentAvailibility = true;

    // class variables
    static int count;


    public Dog() { // default constructor

    }

    public Dog(int dogID, String name, String breed, String sex, int age, int weight) { // full constructor
        this.dogID = dogID;
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.rentAvailibility = true;
    } // end of full constructor


    public int getDogID() {
        return dogID;
    }

    public void setDogID(int dogID) {
        this.dogID = dogID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isRentAvailibility() {
        return rentAvailibility;
    }

    public void setRentAvailibility(boolean rentAvailibility) {
        this.rentAvailibility = rentAvailibility;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Dog.count = count;
    }

    public String toString() {
        return dogID + " " + name + " " + breed + " " + sex +" " +  age + " " + weight + " " + rentAvailibility; // + rent availibility
    }

//    public int compareTo(Dog compareVal) {
//        return this.dogID.compareTo(compareVal.getDogID());
//    }

    public static void sortDogs(Dog[] myDogs) {

        for (int i=0; i<count-1; i++) { // (A)
            int min = i;
            for (int j=i+1; j<count; j++) { // (B)
                if (myDogs[min].getDogID() < myDogs[j].getDogID()) {
                    min = j;
                }
            } // end of (B)

            if (min!=i) {
                swap(myDogs,min,i);
            }

        } // end of (A)

    } // end of sortDogs

    public static void swap(Dog[] myDogs,int min, int i) {

        Dog temp = myDogs[min];
        myDogs[min] = myDogs[i];
        myDogs[i] = temp;


    } // end of swap


} // end of dog class
