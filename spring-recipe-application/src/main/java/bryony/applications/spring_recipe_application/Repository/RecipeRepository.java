package bryony.applications.spring_recipe_application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bryony.applications.spring_recipe_application.POGOS.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

  public List<Recipe> findByNameLike(String name); 
}
