package com.jokecompany.io;

import java.util.List;

/**
 * ConsolePrinter.java : Prints the provided value
 *
 * @author  GeoTab
 * @ModifiedBy: Mithelash Chandrasekaran
 *
 */

public class ConsolePrinter {

    /* Method to print the value */
    public static void Value(String value)
    {
        if(value.length()>0) System.out.println(value);
    }


    /* Method to print the list */
    public void Value(List<String> value)
    {
        if(value.size() > 0 ){
            for(String str: value)  System.out.println(str);
            System.out.println();
        }
        else
            System.out.println("List is empty");
    }

}
