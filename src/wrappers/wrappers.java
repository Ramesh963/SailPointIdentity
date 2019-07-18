package wrappers;


public interface wrappers {
	public void invokeApp(String browser,String url);
	public void EnterDataByXpath(String Xpath,String data);
	public void close();
	public void clickByXpath(String xpath);
	public void hitEnterByXpath(String xpath);
	public void mouseOverByXpath(String xpath);
	public void verifyTextByXpath(String xpath,String text);
	public void loadingObject();
	public void unloadObject();
}
