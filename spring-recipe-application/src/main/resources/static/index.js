
//function to create div content for created recipe
function getRecipeName() {
    const recipeName = document.getElementById("recipeName").value;
    const recipeHeader = document.getElementById("createdRecipeName");
    recipeHeader.innerHTML = recipeName;
}

function getIngredients() {

    const ingredient = document.getElementById("ingredients").value;

    const createdRecipeDiv = document.getElementById("created-recipe-container");

    var ingredientList = document.createElement("ul");
    ingredientList.id = "ingredientList";

    var listItem = document.createElement("li");
    listItem.innerHTML = ingredient;

    ingredientList.appendChild(listItem);
    createdRecipeDiv.appendChild(ingredientList);
}



//async function to send user recipe to db and store