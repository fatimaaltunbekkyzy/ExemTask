package serviceImpl;

import database.Database;
import models.Carnation;
import servise.GenericFlowerService;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarnationServiceImpl implements GenericFlowerService<Carnation> {
    private List<Carnation> carnations;

    public CarnationServiceImpl(List<Carnation> carnations) {
        this.carnations = carnations;
    }

    @Override
    public String addFlowers(List<Carnation> t) {
        carnations.addAll(t);  // Добавление цветов в список
        return "Flowers added successfully!";
    }

    @Override
    public List<Carnation> getAllFlowers() {
        return Database.carnations;
    }

    @Override
    public List<Carnation> getFlowersFinByColor(String color) {
        return carnations.stream()
                .filter(carnation -> carnation.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());  // Фильтрация по цвету
    }

    @Override
    public Map<String, List<Carnation>> groupingFlowersByColor() {
        return carnations.stream()
                .collect(Collectors.groupingBy(Carnation::getColor));
    }

    @Override
    public int getSumAllFlowers() {
        return carnations.stream()
                .mapToInt(Carnation::getPrice)
                .sum();
    }

    @Override
    public List<Carnation> getAllFlowersSortByPrice(String ascendingOrDescending) {
        Comparator<Carnation>carnationComparator=Comparator.comparing(Carnation::getPrice);
        if(ascendingOrDescending.equals("descending")){
            carnationComparator=carnationComparator.reversed();
            Database.carnations.sort(carnationComparator);
        }
        return new LinkedList<>( Database.carnations);
    }
}
