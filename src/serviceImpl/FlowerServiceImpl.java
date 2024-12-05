package serviceImpl;

import database.Database;
import models.Flower;
import servise.GenericFlowerService;

import java.util.*;
import java.util.stream.Collectors;

public class FlowerServiceImpl implements GenericFlowerService {
    private List<Flower> flowers;
    @Override
    public String addFlowers(List t) {
        flowers.addAll(t);
        return "Тюльпаны тизмеге кошулду!";
    }

    @Override
    public List getAllFlowers() {
        return Database.flowers;
    }

    @Override
    public List getFlowersFinByColor(String color) {
        List<Flower> result = new ArrayList<>();
        for (Flower flower : flowers) {
            if (flower.getColor().equalsIgnoreCase(color)) {
                result.add(flower);
            }
        }
        return result;
    }

    @Override
    public Map<String, List> groupingFlowersByColor() {
//        return flowers.stream()
//                .collect(Collectors.groupingBy(Flower::getColor));
        return null;
    }

    @Override
    public int getSumAllFlowers() {
        return flowers.stream()
                .mapToInt(Flower::getPrice)
                .sum();
    }

    @Override
    public List getAllFlowersSortByPrice(String ascendingOrDescending) {
        Comparator<Flower> flowerComparator=Comparator.comparing(Flower::getPrice);
        if(ascendingOrDescending.equals("descending")){
            flowerComparator=flowerComparator.reversed();
            Database.flowers.sort(flowerComparator);
        }
        return  new LinkedList<>(Database.flowers);

    }
}
