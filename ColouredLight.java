public class ColouredLight extends Light 
{
	private String colour;
	
	public ColouredLight(String c)
	{
		colour = c;
	}
	
	//overriding toString(); adds colour to text from superclass
	public String toString() 
	{
		return "Colour is "+colour+", "+ super.toString();
	}
	
}
