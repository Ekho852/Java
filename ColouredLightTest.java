public class ColouredLightTest {

	public static void main(String[] args) 
	{
		ColouredLight bulb = new ColouredLight("Green");
		bulb.on();
		bulb.brighten();
		bulb.dim();
		bulb.dim();
		bulb.off();
	}

}
