package assign10;
//class name FactoryPattern
import java.util.Scanner;

abstract class Car {
 public abstract void allocateAccessories();
 public abstract void assembleBody();
 public abstract void paintCar();
 public abstract void finalMakeup();

 public void buildCar() {
     allocateAccessories();
     assembleBody();
     paintCar();
     finalMakeup();
 }
}

class Hatchback extends Car {
 @Override
 public void allocateAccessories() {
     System.out.println("allocating accessories for hatchback.");
 }

 @Override
 public void assembleBody() {
     System.out.println("assembling body for hatchback.");
 }

 @Override
 public void paintCar() {
     System.out.println("painting hatchback.");
 }

 @Override
 public void finalMakeup() {
     System.out.println("final makeup for hatchback.");
 }
}

class Sedan extends Car {
 @Override
 public void allocateAccessories() {
     System.out.println("allocating accessories for sedan.");
 }

 @Override
 public void assembleBody() {
     System.out.println("assembling body for sedan.");
 }

 @Override
 public void paintCar() {
     System.out.println("painting sedan.");
 }

 @Override
 public void finalMakeup() {
     System.out.println("final makeup for sedan.");
 }
}


class SUV extends Car {
 @Override
 public void allocateAccessories() {
     System.out.println("allocating accessories for SUV.");
 }

 @Override
 public void assembleBody() {
     System.out.println("assembling body for SUV.");
 }

 @Override
 public void paintCar() {
     System.out.println("painting SUV.");
 }

 @Override
 public void finalMakeup() {
     System.out.println("final makeup for SUV.");
 }
}

class CarFactory {
 public static Car createCar(String carType) {
     switch (carType.toLowerCase()) {
         case "hatchback":
             return new Hatchback();
         case "sedan":
             return new Sedan();
         case "suv":
             return new SUV();
         default:
             throw new IllegalArgumentException("unknown car type: " + carType);
     }
 }
}

public class FactoryPattern {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     while (true) {
         System.out.println("\nchoose a car type to build:");
         System.out.println("1. hatchback");
         System.out.println("2. sedan");
         System.out.println("3. SUV");
         System.out.println("4. exit");
         System.out.print("enter your choice: ");

         int choice = scanner.nextInt();
         scanner.nextLine();

         switch (choice) {
             case 1:
                 Car hatchback = CarFactory.createCar("Hatchback");
                 System.out.println("building a hatchback:");
                 hatchback.buildCar();
                 break;
             case 2:
                 Car sedan = CarFactory.createCar("Sedan");
                 System.out.println("building a sedan:");
                 sedan.buildCar();
                 break;
             case 3:
                 Car suv = CarFactory.createCar("SUV");
                 System.out.println("building an SUV:");
                 suv.buildCar();
                 break;
             case 4:
                 System.out.println("exiting the system");
                 scanner.close();
                 return;
             default:
                 System.out.println("invalid choice.");
         }
     }
 }
}
