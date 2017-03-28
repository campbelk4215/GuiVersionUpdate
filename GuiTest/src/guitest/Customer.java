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
public class Customer 
{
    private String username;
    private int userID;
    private List<Event> customerEvent = new ArrayList<Event>();
    private List<Order> customerOrders = new ArrayList<Order>();
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String name)
    {
        username = name;
    }
    public int getUserID()
    {
        return userID;
    }
    public void setUserID(int ID)
    {
        userID = ID;
    }
    
}
