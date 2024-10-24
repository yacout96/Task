package resources;

public class APIConstants {
	//This class contains any external information that is needed for testing
	
	//URLs
	public final String baseURL = "https://pay2.foodics.dev";
	public final String whoAmIEndpoint = "/cp_internal/whoami";
	public final String loginEndpoint = "/cp_internal/login";
	
	//User Information
	public final String validEmail = "merchant@foodics.com";
	public final String validPassword = "123456";
    public final String merchantUserSuccessToken = "d5fa1c8c5c328e7820471a9a2352832a";
    public final String inValidEmail = "Invalid@foodics.com";
    public final String inValidEmail2 = "Invalid2@foodics.com";
    public final String inValidPassword = "189rufbe";
    
    //Messages and Errors
    public final String tooManyIncorrectPasswordsError = "You have entered the incorrect password multiple times. For your security, you have to wait for";
    public final String incorrectCredentialsError = "These credentials do not match our records.";

    
}
