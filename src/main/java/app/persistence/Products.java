package app.persistence;


import jakarta.persistence.*;



@Entity
public class Products {

    @Id
    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "picture", length = 300)
    private String pictrure;

    @Column(name = "price")
    private int price;

    @Column(name = "recipe", columnDefinition="TEXT")
    private String recipe;

    @Column(name = "allergies", columnDefinition="TEXT")
    private String allergies;

    @Column(name = "ingredients", columnDefinition="TEXT")
    private String ingredients;

    @Column(name = "store_id")
    private int store_id;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "lastUse", length = 100)
    private String lastUse;

    public Products(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPictrure(String pictrure) {
        this.pictrure = pictrure;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLastUse(String lastUse) {
        this.lastUse = lastUse;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    // getter


    public String getPictrure() {
        return pictrure;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getCategory() {
        return category;
    }

    public String getLastUse() {
        return lastUse;
    }
}
