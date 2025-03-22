package ru.home.model.comparator;

import ru.home.model.RootVegetable;

import java.util.Comparator;

public class RootVegetableTypeComparator implements Comparator<RootVegetable> {
    @Override
    public int compare(RootVegetable rv1, RootVegetable rv2) {
        return rv1.getType().compareTo(rv2.getType());
    }
}