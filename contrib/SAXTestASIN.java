import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

/**
   This program demonstrates how to use a SAX parser. The
   program prints all <ASIN> contents of an XML file
   Usage: java SAXTestASIN fname
*/
public class SAXTestASIN
{
   public static void main(String[] args) throws Exception
   {
      String fname;
      if (args.length == 0)
      {
         fname = "aws_dog.xml";
         System.out.println("Using " + fname);
      }
      else
         fname = args[0];

      DefaultHandler handler = new 
         DefaultHandler()
         {
	     private StringBuffer headingContent;
	     private boolean inHeading;

            public void startElement(String namespaceURI,
                         String localName, String qname, Attributes attrs)
            {
		if (qname.equalsIgnoreCase("ASIN")){
		    headingContent=new StringBuffer();
		    inHeading=true;
		}
            }                        

            public void endElement(String namespaceURI,
                         String localName, String qname)
            {
		if (qname.equalsIgnoreCase("ASIN")){
		    System.out.println(headingContent);
		    inHeading=false;
		}
            }    

	     public void characters(char[] ch,
				    int start,
				    int length)
	     {
		 if(inHeading){
		     headingContent.append(ch,start,length);
		 }
	     }
         };

      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      //      InputStream in = new URL(url).openStream();
      saxParser.parse(new File(fname), handler);     
   }
}
