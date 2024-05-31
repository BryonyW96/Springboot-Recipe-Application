package bryony.applications.spring_recipe_application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bryony.applications.spring_recipe_application.POGOS.Recipe;
import bryony.applications.spring_recipe_application.Repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
    
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }




  

    
}
