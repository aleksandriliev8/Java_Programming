package data.model;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public interface RandomCategorySupplier extends Supplier<List<Inventory>> {

    private void updateType(Category type){
        if(type == null){
            throw new InvalidParameterException();
        }

        type.setSuppliers(new ArrayList<>());
        int rand = CanRandomize.RAND.GENERATOR.nextInt(1, 4 + 1);
        List<String> newSuppliers = new ArrayList<>(rand);
        for (int i = 0; i < rand; i++) {
            newSuppliers.add(String.format("%s Supplier No. %d", type.name(),rand));
        }

        type.setSuppliers(newSuppliers);
        type.setReorderQty(CanRandomize.RAND.GENERATOR.nextInt(1, (10 * rand) + 1));
    }

    default List<Inventory> getRandomData(int howMany, int a, int b){
        List<Inventory> newListInventory = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            Category type = Category.values()[CanRandomize.RAND.GENERATOR.nextInt(Category.values().length)];
            updateType(type);
            double randomPrice = CanRandomize.RAND.GENERATOR.nextDouble() * (b - a) + a;
            newListInventory.add(new Inventory(String.valueOf(i), type, randomPrice));
        }

        return newListInventory;
    }
}
