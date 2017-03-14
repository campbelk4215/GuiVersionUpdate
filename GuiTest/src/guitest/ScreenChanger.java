/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

/**
 * This class stores a Guitest Object as a static field this allows Guitest 
 * methods to be called from anywhere without creating another object
 * those methods load the various FXML files
 * ScreenChanger.getGuiTest().Whatever method
 * @author Joshua Happel
 */
public class ScreenChanger 
{
    private static GuiTest gt;
    public static GuiTest getGuiTest()
    {
        return gt;
    }
    public static void setGuiTest(GuiTest g)
    {
        gt = g;
    }
    
}
