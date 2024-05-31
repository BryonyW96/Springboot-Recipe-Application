package bryony.applications.spring_recipe_application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bryony.applications.spring_recipe_application.POGOS.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    //need get by name here
    //need delete by name here
}
