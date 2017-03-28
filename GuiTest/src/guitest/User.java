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
public class User 
{
    private int userID;
    private boolean isAdmin = false;
    private String username;
    private String password;
    private List<Event> userEvent = new ArrayList<Event>();
    private List<Order> userOrders = new ArrayList<Order>();
    public User()
    {
        
    }
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, int userID, boolean isAdmin)
    {
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.isAdmin = isAdmin;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String name)
    {
        username = name;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String pass)
    {
        password = pass;
    }
    public int getUserID()
    {
        return userID;
    }
    public void setUserID(int ID)
    {
        userID = ID;
    }
    public boolean getIsAdmin()
    {
        return isAdmin;
    }
    public void setIsAdmin(boolean b)
    {
        isAdmin = b;
    }
    public void addEvent(Event e)
    {
        userEvent.add(e);
    }
    public void removeEvent(Event e)
    {
        userEvent.remove(e);
    }
    public List<Event> getEventList()
    {
        return userEvent;
    }
    public void addOrder(Order o)
    {
        userOrders.add(o);
    }
    public void removeOrder(Order o)
    {
        userOrders.remove(o);
    }
    public List<Order> getOrderList()
    {
        return userOrders;
    }
    
}
