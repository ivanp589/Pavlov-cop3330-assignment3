package ex44;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.out;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 ivan pavlov
 */

public class productSearch {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        productSearch search = new productSearch();
        //open the json file using appropriate functions
        //and store the objects found inorder to create a map of them
        //ask for a product name to query the map and find the values needed to e outputted
        JsonObject productListjson = search.openjson();
        HashMap<String,Product> products = search.createHash(productListjson);
        String productName = search.getName(products);
        String outputString = search.output(products, productName);
        out.println(outputString);

    }
    //create function to autocapitalize the first letter of every string because
    //strings have the first letters capitalized in the file
    //plus im too lazy to press the shift button. but good functionality
    public String productCapilization( String productName) {
        //find first character and check if it is bigger than the ascii value for Z
        //if it is replace it by adding 32 to it
        char c = productName.charAt(0);
        if(c>90) {
            char[] nameArr=productName.toCharArray();
            nameArr[0]=  (char) (c-32);
            productName= new String(nameArr);
            }
         return productName;
            }
    //create the output string to show the user what they were looking for
    public String output(HashMap<String, Product> products, String productName) {
        //creates a string which we then use to print output
        return String.format("Name: %s\nPrice: %s\nQuantity: %d", products.get(productName).getName(),
                products.get(productName).getPrice(), products.get(productName).getQuantity());
        }
    //check if the product is in the system a simple true or false
    public boolean isProductInSystem(String productName, HashMap<String, Product> products) {
        return products.containsKey(productName);
    }
    //ask for the user to inpuit a particular product and dont stop until one is found
    public String getName(HashMap<String, Product> productHashMap) {
        //check for product and if found returns name
            boolean productMap = false;
            String productName = "";
            while (!productMap) {
                out.print("What is the product name? ");
                productName = in.nextLine();
                productName= productCapilization(productName);
        //run capitilization program to make sure the product isnt found because it was lower case
                productMap = isProductInSystem(productName, productHashMap);
                if(!productMap) {
                    out.println("Sorry, that product was not found in our inventory.");
                }
            }
            return productName;
        }

    //create a hashmap of all products keys and their class
    public HashMap<String,Product> createHash(JsonObject productListjson) {
        Gson gson = new Gson();
        HashMap<String,Product> productMap = new HashMap<>();
        JsonArray products = productListjson.getAsJsonArray("products");
        //dont stop making the hashmap untill all products are entered
        for (int i = 0; i<products.size(); i++) {
            Product product = gson.fromJson(products.get(i), Product.class);
            productMap.put(product.getName(), product);
        }
        return productMap;
    }
    //open the proper json file at the specific location
    public JsonObject openjson() throws FileNotFoundException {
        JsonParser jsonParser = new JsonParser();
        Object input = jsonParser.parse(new FileReader("src/main/java/ex44/exercise44_input.json"));

        JsonObject jsonObject;
        jsonObject = (JsonObject) input;
        return jsonObject;
    }
}
