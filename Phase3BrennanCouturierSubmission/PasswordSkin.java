

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.TextFieldSkin;
import javafx.scene.paint.Color;

/**
 * This class allows us to customize how the login's password field hides the input.
 * @author Brennan Couturier, 3638808
 */
public class PasswordSkin extends TextFieldSkin {
    public PasswordSkin(TextField textField) {
        super(textField);
    }

    protected String maskText(String txt) {
        if (getSkinnable() instanceof PasswordField)
        {
            int n = txt.length();
            StringBuilder passwordBuilder = new StringBuilder(n);
            for (int i = 0; i < n; i++)
            {
            	 //passwordBuilder.append("*");
            	/*
            	if (i % 2 == 0)
            	{
            		passwordBuilder.append("*");
            	}
            	else
            	{
            		passwordBuilder.append("~");
            	}
        		*/
            }
               

            return passwordBuilder.toString();
        } 
        else 
        {
            return txt;
        }
    }
}