
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.TextFieldSkin;

public class PasswordSkin extends TextFieldSkin {
    public PasswordSkin(TextField textField) {
        super(textField);
    }

    protected String maskText(String txt) {
        if (getSkinnable() instanceof PasswordField) {
            int n = txt.length();
            StringBuilder passwordBuilder = new StringBuilder(n);
            for (int i = 0; i < n; i++)
                passwordBuilder.append("*");
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

            return passwordBuilder.toString();
        } else {
            return txt;
        }
    }
}