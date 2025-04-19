package quizcheat.backend.dto.request;

public class ApiDocsRequest {
    private String method;
    private String endpoint;
    private String comment;
    private String auth;

    public ApiDocsRequest(String method, String endpoint, String comment, String auth) {
        this.method = method;
        this.endpoint = endpoint;
        this.comment = comment;
        this.auth = auth;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

}
