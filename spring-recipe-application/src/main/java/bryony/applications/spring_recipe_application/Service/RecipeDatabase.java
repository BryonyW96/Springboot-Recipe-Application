package bryony.applications.spring_recipe_application.Service;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bryony.applications.spring_recipe_application.POGOS.Recipe;

public class RecipeDatabase {

    private final String INSERT_STATEMENT = "INSERT INTO recipes (name, ingredients) VALUES (LOWER(?), ?);";
    private final String SELECT_ALL_STATEMENT = "SELECT * FROM recipes;";
    private final String DELETE_STATEMENT = "DELETE FROM recipes WHERE name=LOWER(?)";
    private final String selectStatement = "SELECT * FROM recipes WHERE name LIKE LOWER(?);";

    public RecipeDatabase() {
    }

    // CONNECT TO DB
    // public Connection connectDB() throws SQLException, ClassNotFoundException {
    //     Class.forName("org.postgresql.Driver");
    //     return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    // }

    // RETURNS ALL RECIPES FROM TABLE
    public List<Recipe> getAllRecipes(Connection connection) {

        List<Recipe> recipeResults = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STATEMENT);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String name = resultSet.getString("name");
                String[] ingredients = (String[]) resultSet.getArray("ingredients").getArray();

                recipeResults.add(new Recipe(name, ingredients));

            }
            recipeResults.forEach(System.out::print);
            return recipeResults;

        } catch (SQLException e) {
            System.out.println("Could not return results: " + e.getMessage());
            return null;
        }
    }

    // RETURNS SPECIFIC RESULT FROM TABLE

    public List<Recipe> getRecipe(Connection connection, String name) {

        List<Recipe> recipeResults = new ArrayList<>();
        
        String fuzzySearch = "%" + name + "%"; 

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);
            preparedStatement.setObject(1, fuzzySearch);
            ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    String recipeName = resultSet.getString("name");
                    String[] ingredients = (String[]) resultSet.getArray("ingredients").getArray();
                    recipeResults.add(new Recipe(recipeName, ingredients));
                }

                recipeResults.forEach(System.out::println);
                return recipeResults;
            
        } catch (SQLException e) {
            System.out.println("Could not retrieve recipe from table: " + e.getMessage());
            return null;
        }

    }

    // INSERTS RECIPE INTO TABLE
    public void insertRecipe(Connection connection, String name, String[] ingredients) {

        Arrays.sort(ingredients);

        try {

            Array ingredientArray = connection.createArrayOf("text", ingredients);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT);
            preparedStatement.setString(1, name);
            preparedStatement.setArray(2, ingredientArray);
            preparedStatement.executeUpdate();
            System.out.println(name + ": inserted");

        } catch (SQLException e) {
            System.out.println("Could not insert row into table: " + e.getMessage());
        }

    }

    public void deleteRecipe(Connection connection, String name) {

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STATEMENT);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            System.out.println(name + ": DELETED");

        } catch (SQLException e) {
            System.out.println("Could not delete item from table: " + e.getMessage());
        }

    }

}