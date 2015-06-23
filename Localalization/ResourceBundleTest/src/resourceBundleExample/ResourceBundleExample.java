package resourceBundleExample;

import java.util.*;

public final class ResourceBundleExample {
	
   private ResourceBundleExample(){}
	
   public static void main(String args[]) throws MissingResourceException {
 
     String resourceName = "resourceBundleExample.RBExample";
     ResourceBundle rb;
 
     // Default locale
     rb = ResourceBundle.getBundle(resourceName);
     System.out.println("Default : " + rb.getString("Hello" + ".text"));
      
     // No property file for China in this example... use default 
     rb = ResourceBundle.getBundle(resourceName, Locale.CHINA); 
     System.out.println("Chinese : " + rb.getString("Hello" + ".text"));
   } 
}