package geotp;

 

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
public class Lire
{
    public static String S(){return S("");}
    public static String S(String invite) // Lire un String
    {
        if(invite.length()!=0) System.out.print(invite+" : ");
        String tmp = "";
        char C='\0';
        try {
            while ((C=(char) System.in.read()) !='\n')
            {
                if (C != '\r')  tmp = tmp+C;

            }
        }
        catch (IOException e)
        {
            System.out.println("Erreur de frappe");
            System.exit(0);
        }
        return tmp;
    } // fin de S()

    public static byte b(){return b("");}
    public static byte b(String invite)  // Lire un entier byte
    {
        boolean ok;
        byte x=0;
        do
        { 
            ok=true; 
            try 
            {
                x=Byte.parseByte(S(invite));
            }
            catch (NumberFormatException e) {
                System.out.println("La valeur saisie n'est pas de type byte ; Recommencez !");
                ok=false;
            }
        }
        while(!ok);
        return x ;
    }

    public static short s(){return s("");}
    public static short s(String invite)  // Lire un entier short
    {
        boolean ok;
        short x=0;
        do
        { 
            ok=true; 
            try 
            {
                x=Short.parseShort(S(invite));
            }
            catch (NumberFormatException e) {
                System.out.println("La valeur saisie n'est pas un entier court ; Recommencez !");
                ok=false;
            }
        }
        while(!ok);
        return x ;
    }

    public static int i(){return i("");}
    public static int i(String invite)  // Lire un entier int
    {
        boolean ok;
        int x=0;
        do
        { 
            ok=true; 
            try 
            {
                x=Integer.parseInt(S(invite));
            }
            catch (NumberFormatException e) {
                System.out.println("La valeur saisie n'est pas un entier ; Recommencez !");
                ok=false;
            }
        }
        while(!ok);
        return x ;
    }

    public static long l(){return l("");}
    public static long l(String invite)  // Lire un entier long
    {
        boolean ok;
        long x=0;
        do
        { 
            ok=true; 
            try 
            {
                x=Long.parseLong(S(invite));
            }
            catch (NumberFormatException e) {
                System.out.println("La valeur saisie n'est pas un entier long ; Recommencez !");
                ok=false;
            }
        }
        while(!ok);
        return x ;
    }

    public static double d(){return d("");}
    public static double d(String invite)  // Lire un double
    {
        boolean ok;
        double x=0.0;
        do
        { 
            ok=true; 
            try 
            {
                x=Double.valueOf(S(invite)).doubleValue();
            }
            catch (NumberFormatException e) {
                System.out.println("La valeur saisie n'est pas un nombre décimal ; Recommencez !");
                ok=false;
            }
        }
        while(!ok);
        return x ;
    }

    public static float f(){return f("");}
    public static float f(String invite)  // Lire un float
    {
        boolean ok;
        float x=0.0f;
        do
        { 
            ok=true; 
            try 
            {
                 x=Double.valueOf(S(invite)).floatValue();
            }
            catch (NumberFormatException e)
            {
                System.out.println("La valeur n'est pas un float ; Recommencez !");
                ok=false;
            }
        }
        while(!ok);
        return x ;
    }

    public static char c(){return c("");}
    public  static char c(String invite)  // Lire un caractere
    {
        String tmp=S(invite);
        if (tmp.length()==0)
            return '\n';
        else
        {
            return tmp.charAt(0);
        }
    }
}
