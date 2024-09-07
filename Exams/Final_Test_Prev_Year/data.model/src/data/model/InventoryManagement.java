package data.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryManagement {
    private RandomCategorySupplier supplier;
    private List<Inventory> inventories;

    public InventoryManagement(RandomCategorySupplier supplier, List<Inventory> inventories) {
        this.supplier = new RandomCategorySupplier() {
            @Override
            public List<Inventory> get() {
                return new ArrayList<>();
            }
        };
        this.inventories = this.supplier.getRandomData(5,10,20);
    }

    public String showInventory(){
        return inventories.stream().map(Inventory::toString).collect(Collectors.joining("\n"));
    }

    public double averagePrice(){
        return inventories.stream().mapToDouble(Inventory::getPrice).average().orElse(0.00);
    }

    public List<Inventory> sortInventoryTypeAndID(){
        return inventories.stream().sorted(Comparator.comparing(Inventory::getCategory).reversed()
                .thenComparing(Inventory::getId)).toList();
    }

    public String  findLargestPricePerCategory(){
        return "The largest price per categories: \n" + inventories.stream().collect(Collectors.groupingBy(Inventory::getCategory)).entrySet().stream()
                .map(e -> "Category: " + e.getKey() + ", Max price: " + e.getValue().stream().max(Comparator.comparingDouble(Inventory::getPrice)).get())
                .collect(Collectors.joining("\n"));
    }
}
