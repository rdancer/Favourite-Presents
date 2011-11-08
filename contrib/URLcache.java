import java.net.*;
import java.io.*;

public class URLcache{

    public static void main (String[] args) throws Exception{
	URL url=new URL("http://www.dur.ac.uk/");
	//	URL url=new URL("http://www.bbc.co.uk/");
	BufferedReader in = 
	    new BufferedReader(new InputStreamReader(url.openStream()));
	
	String inputLine;
	
	while ((inputLine = in.readLine()) != null)
	    System.out.println(inputLine);
	
	in.close();
    }
}
