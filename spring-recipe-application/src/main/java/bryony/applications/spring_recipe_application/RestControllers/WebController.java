package bryony.applications.spring_recipe_application.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bryony.applications.spring_recipe_application.POGOS.Recipe;
import bryony.applications.spring_recipe_application.Service.RecipeServiceImpl;

@RestController
public class WebController {

    @Autowired
    private RecipeServiceImpl recipeServiceImpl; 

    @RequestMapping(method = RequestMethod.GET, value = "/get", produces="application/json")
    public String saveRecipe(@RequestParam String name) {
        System.out.println(name);
        return name; 
    }
    
}
