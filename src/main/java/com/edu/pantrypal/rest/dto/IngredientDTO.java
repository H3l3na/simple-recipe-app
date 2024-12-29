package src.main.java.com.edu.pantrypal.rest.dto;

public class IngredientDTO {

    private String name;
    private String quantity;

    public IngredientDTO(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
