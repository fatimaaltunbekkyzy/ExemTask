package serviceImpl;

import database.Database;
import models.Flower;
import models.Tulip;
import servise.GenericFlowerService;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static database.Database.*;

public class TulipServiceImpl implements GenericFlowerService<Tulip> {
    private List<Tulip> tulip;

    public TulipServiceImpl(List<Tulip> tulip) {
        this.tulip = tulip;
    }

    @Override
    public String addFlowers(List<Tulip> t) {
        tulips.addAll(t);
        return "Тюльпаны тизмеге кошулду!";
    }

    @Override
    public List<Tulip> getAllFlowers() {
        return tulips;
    }

    @Override
    public List<Tulip> getFlowersFinByColor(String color) {
        return tulips.stream()
                .filter(tulip -> tulip.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Tulip>> groupingFlowersByColor() {
        return tulips.stream()
                .collect(Collectors.groupingBy(Tulip::getColor));
    }

    @Override
    public int getSumAllFlowers() {
        return flowers.stream()
                .mapToInt(Flower::getPrice)
                .sum();
    }

    @Override
    public List<Tulip> getAllFlowersSortByPrice(String ascendingOrDescending) {
        Comparator<Tulip> tulipComparator=Comparator.comparing(Tulip::getPrice);
        if(ascendingOrDescending.equals("descending")){
            tulipComparator=tulipComparator.reversed();
           Database.tulips.sort(tulipComparator);
        }
        return  new LinkedList<>(Database.tulips);
    }
}
