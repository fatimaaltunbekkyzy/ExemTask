import database.Database;
import models.Carnation;
import models.Flower;
import models.Rose;
import models.Tulip;
import serviceImpl.CarnationServiceImpl;
import serviceImpl.FlowerServiceImpl;
import serviceImpl.RoseServiceImpl;
import serviceImpl.TulipServiceImpl;
import servise.GenericFlowerService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GenericFlowerService flowerService = new FlowerServiceImpl();
//        GenericFlowerService flowerService1 = new RoseServiceImpl();
//        GenericFlowerService flowerService2= new TulipServiceImpl();
//        GenericFlowerService flowerService3= new CarnationServiceImpl();

        Database.flowers.add(new Flower("Франция", 12, "Сары", 200));
        Database.flowers.add(new Flower("Франция", 23, "курон", 130));

        Database.roses.add(new Rose("Испания", 13, "red", 140));
        Database.roses.add(new Rose("Испания", 14, "кара", 145));

        Database.tulips.add(new Tulip("Россия", 15, "жашыл", 160));
        Database.tulips.add(new Tulip("Россия", 16, "ак", 170));

        Database.carnations.add(new Carnation("Италия", 20, "Кызыл", 100));  // Добавление примера
        Database.carnations.add(new Carnation("Италия", 15, "Кок", 120));

        while (true) {
            System.out.println("\nТөмөнкү аракеттердин бирин тандаңыз:");
            System.out.println("1 - get All Flowers");
            System.out.println("2 - get Flowers FinBy Color");
            System.out.println("3 - grouping Flowers ByColor");
            System.out.println("4 - get Sum All Flowers");
            System.out.println("5 - get All Flowers Sort By Price");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.println("getAllFlowers");
                System.out.println(flowerService.getAllFlowers());
            }
              case 2-> {
                  System.out.println("getFlowersFinByColor");
                  String fColor = scanner.nextLine();
                  System.out.println(flowerService.getFlowersFinByColor(fColor));
              }
            case 3->{
                System.out.println("groupingFlowersByColor");
                String gColor=scanner.nextLine();
                System.out.println(flowerService.groupingFlowersByColor());
            }
            case 4-> {
               System.out.println("getSumAllFlowers");
               System.out.println(flowerService.getSumAllFlowers());
}
            case 5->{
                System.out.println("getAllFlowersSortByPrice");
                System.out.println(flowerService.getAllFlowersSortByPrice("ascending"));
           }
//                case 3->{
//    System.out.println("get All Rose");
//    System.out.println(flowerService1.getAllFlowers());
//
//    System.out.println("et Rose Fin By Color");
//    System.out.println(flowerService1.getFlowersFinByColor("кара"));

//    System.out.println("grouping Rose By Color");
//    System.out.println(flowerService1.groupingFlowersByColor());
//
//    System.out.println("get Sum All Rose");
//    System.out.println(flowerService1.getSumAllFlowers());
//
//    System.out.println("get All Rose Sort By Price");
//    System.out.println(flowerService1.getAllFlowersSortByPrice("decending"));}
                //  case 3-> {

            }
//}
//           case 4->
//                System.out.println("Invalid action specified");
//        }

        }
    }}