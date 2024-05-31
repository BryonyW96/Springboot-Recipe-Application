package bryony.applications.spring_recipe_application.Service;

import java.util.List;

import bryony.applications.spring_recipe_application.POGOS.Recipe;

public interface RecipeService {

    List<Recipe> getAllRecipes();
    
    void save(Recipe recipe);
    
} 
