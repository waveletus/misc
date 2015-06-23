import java.util.*;

public class PropertiesDemo
{
 static void displayValue(Locale currentLocale, String key)
 {
  ResourceBundle labels=ResourceBundle.getBundle("LabelsBundle",currentLocale);
   String value=labels.getString(key);
   System.out.println("Locale="+currentLocale.toString()+"key="+key+","+"value="+value);
 }

 static void iterateKeys(Locale currentLocale)
 {
  ResourceBundle labels=ResourceBundle.getBundle("LabelsBundle",currentLocale);
   Enumeration bundlekey=labels.getKeys();

     
    while(bundlekey.hasMoreElements())
    {
     String key=(String)bundlekey.nextElement();
      String value=labels.getString(key);
       System.out.println("key="+key+","+"value="+value);
    }
  }

 public static void main(String a[])
 {
 Locale[] supportedLocales={
                           Locale.FRENCH,
                           Locale.GERMAN,
                           Locale.ENGLISH
                           };


  System.out.println("the s2 values in French,German n English : ");
   for(int i=0;i<supportedLocales.length;i++)
    {
     displayValue(supportedLocales[i],"s2"); 
    }
   
    System.out.println();
     System.out.println("\n the disk,computer,moniter n keyboard in French language:");
      iterateKeys(supportedLocales[0]);
 }
 


} 