/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joshua Happel <happelj0841@student.faytechcc.edu>
 */
public class Order 
{
    private List<Item> items = new ArrayList<Item>();
    public void addItem(Item i)
    {
        items.add(i);
    }
    public void removeItem(Item i)
    {
        items.remove(i);
    }
}
