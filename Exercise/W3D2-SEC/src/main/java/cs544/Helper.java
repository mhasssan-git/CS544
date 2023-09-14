package cs544;

import java.text.DecimalFormat;

public class Helper {
    public static String getFormat( double money )
    {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        return df.format(money);
    }
}
