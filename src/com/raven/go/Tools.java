
package com.raven.go;

public class Tools {
    public static boolean verifNumeric(String ch)
    {
        for(int i=0;i<ch.length();i++)
        {
            if(!Character.isDigit(ch.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    public static boolean verifAlpha(String ch)
    {
        for(int i=0;i<ch.length();i++)
        {
            if(!Character.isAlphabetic(ch.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    public static boolean verifAbonnement(String ch)
    {
        return(ch.equals("normal")||ch.equals("premium"));
    }
}
