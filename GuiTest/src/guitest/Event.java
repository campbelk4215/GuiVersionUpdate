/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

/**
 *
 * @author happelj0841
 */
public class Event
{
    private String date;
    private String time;
    private int guests;
    
    public Event(String date, String time, int guests)
    {
        this.date = date;
        this.time = time;
        this.guests = guests;
    }
    public Event()
    {
        
    }
    public void setDate(String d)
    {
        date = d;
    }
    public void setTime(String t)
    {
        time = t;
    }
    public void setGuests(int g)
    {
        guests = g;
    }
    public String getDate()
    {
        return date;
    }

    public String getTime()
    {
        return time;
    }
    public int getGuests()
    {
        return guests;
    }
}
