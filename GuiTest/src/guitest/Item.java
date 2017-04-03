/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

/**
 *
 * @author Joshua Happel <happelj0841@student.faytechcc.edu>
 */
public class Item 
{
    private int itemID = 1;
    private String itemName = "goat";
    private double price = 100.00;
    private String imagePath = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Hausziege_04.jpg/220px-Hausziege_04.jpg";

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public Item()
    {
        
    }
    public void setItemID(int ID)
    {
        itemID = ID;
    }
    public int getItemID()
    {
        return itemID;
    }
}
