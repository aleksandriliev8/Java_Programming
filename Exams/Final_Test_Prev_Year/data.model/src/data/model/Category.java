package data.model;
import java.security.InvalidParameterException;
import java.util.List;

public enum Category {
    A(0, List.of("A")),
    B(1, List.of("B")),
    C(2, List.of("C")),
    D(3, List.of("D"));

    private int reorderQty;
    private List<String> suppliers;

    Category(int reorderQty, List<String> suppliers) {
        setReorderQty(reorderQty);
        setSuppliers(suppliers);
    }

    public int getReorderQty() {
        return reorderQty;
    }

    public void setReorderQty(int reorderQty) {
        if(reorderQty >= 0){
            this.reorderQty = reorderQty;
        } else {
            this.reorderQty = 0;
        }
    }

    public List<String> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<String> suppliers) {
        if(suppliers != null){
            this.suppliers = suppliers;
        } else {
            throw new InvalidParameterException();
        }
    }
}
