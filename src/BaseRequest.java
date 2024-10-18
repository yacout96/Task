public abstract class BaseRequest {

    protected String baseUrl;

    public BaseRequest(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setHeader(String name, String value) {
        // Implement logic to set headers
    }

    // Add other methods for setting parameters, cookies, etc.
}