package app;

import app.persistence.Employee;
import app.persistence.EmployeeDAO;
import app.persistence.Products;
import app.persistence.ProductsDAO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProductsDAO productsDAO = new ProductsDAO();

        Products newproduct = new Products();
        newproduct.setName("BroccolieSalat");
        newproduct.setPrice(19);
        newproduct.setIngredients("2kg Broccoli \n1kg Fehår\n200g Bacon\n250g Tranebær\n200g Løg tern\n100g Rødvinseddike\n1kg Mayonaise\n100g Floormelis");
        newproduct.setRecipe("Mix Broccoli, Fehår, Løg, Bacon og Tranebær i en container.\nMix Mayonaise, Floormelis og Rødvinsedikke grundigt sammen, derefter hel det ned sammen med Broccoli salaten bland det");
        newproduct.setStore_id(8830);
        newproduct.setLastUse("+3 dage");
        newproduct.setCategory("Salat");
        Products createdproduct = productsDAO.save(newproduct);

        Products foundProduct = productsDAO.findByName(createdproduct.getName());
        System.out.println("found Employee: " + foundProduct.getIngredients());


        productsDAO.close();

    }
}