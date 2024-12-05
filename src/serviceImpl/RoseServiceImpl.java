package serviceImpl;

import models.Rose;
import servise.GenericFlowerService;

import java.util.*;
import java.util.stream.Collectors;

public class RoseServiceImpl implements GenericFlowerService<Rose> {
    private List<Rose> roses;
    public RoseServiceImpl(List<Rose> roses) {
        this.roses = roses;
    }

    @Override
    public String addFlowers(List<Rose> t) {
        roses.addAll(t);
        return "Тюльпаны тизмеге кошулду!";
    }

    @Override
    public List<Rose> getAllFlowers() {
        return roses;
    }

    @Override
    public List<Rose> getFlowersFinByColor(String color) {
        List<Rose> result = new ArrayList<>();
        for (Rose rose : roses) {
            if (rose.getColor() != null && rose.getColor().equalsIgnoreCase(color)) {
                result.add(rose);
            }
        }
        return result;
    }

    @Override
    public Map<String, List<Rose>> groupingFlowersByColor() {
        return roses.stream()
                .collect(Collectors.groupingBy(Rose::getColor)); //
    }

    @Override
    public int getSumAllFlowers() {
        return roses.stream()
                .mapToInt(Rose::getPrice)
                .sum();
    }

    @Override
    public List<Rose> getAllFlowersSortByPrice(String ascendingOrDescending) {
//        Comparator<Rose> roseComparator = Comparator.comparing(Rose::getPrice);
//
//        // Проверяем, если нужно сортировать по убыванию
//        if ("descending".equalsIgnoreCase(ascendingOrDescending)) {
//            roseComparator = roseComparator.reversed(); // Меняем порядок на убывание
//        }
//        return Database.roses.stream()
//                .sorted(roseComparator)
//                .collect(Collectors.toList());
        return  null;
    }
}
