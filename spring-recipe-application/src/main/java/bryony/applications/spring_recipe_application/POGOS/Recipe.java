package bryony.applications.spring_recipe_application.POGOS;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name; 
    private String[] ingredients;

    public Recipe() {
    }

    public Recipe(String name, String[] ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public Long getId(){
        return id; 
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
