package bryony.applications.spring_recipe_application.RestControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bryony.applications.spring_recipe_application.POGOS.Recipe;
import bryony.applications.spring_recipe_application.Repository.RecipeRepository;
import bryony.applications.spring_recipe_application.Service.RecipeServiceImpl;

@RestController
public class WebController {

    @Autowired
    private RecipeServiceImpl recipeServiceImpl; 

    @Autowired
    private RecipeRepository recipeRepository;


    @RequestMapping(method = RequestMethod.POST, value = "/saveRecipe", produces="application/json")
    public void saveRecipe(@RequestBody Recipe recipe) {
        recipeServiceImpl.save(recipe); 
    }

    @RequestMapping(method = RequestMethod.GET, value="/getAllRecipes", produces="application/json")
    public List<Recipe> getAllRecipes() {
        return recipeServiceImpl.getAllRecipes(); 
    }

    @RequestMapping(method = RequestMethod.GET, value="/getRecipe", produces="application/json") 
    public ResponseEntity<List<Recipe>> getRecipeByName(@RequestParam String name) {
        return new ResponseEntity<>(recipeRepository.findByNameLike(name), HttpStatusCode.valueOf(200));
    }

   

    
    
}
