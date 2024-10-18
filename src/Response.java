public abstract class Response {

    protected int statusCode;
    protected String body;

    public Response(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public boolean isSuccessful(){
        return statusCode >= 200 && statusCode < 300;
    }

    // Add methods for parsing JSON, extracting data, etc.
}