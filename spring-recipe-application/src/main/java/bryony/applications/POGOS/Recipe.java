package bryony.applications.POGOS;

import java.util.Arrays;

public class Recipe {

    private String name; 
    private String[] ingredients;

    public Recipe() {
    }

    public Recipe(String name, String[] ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getIngredients() {
        return ingredients;
    }
    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe [name=" + name + ", ingredients=" + Arrays.toString(ingredients) + "]";
    } 

    

    
    
}
