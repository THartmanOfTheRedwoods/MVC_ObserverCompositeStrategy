public class HttpResponse {
    private StringBuilder body;

    public HttpResponse() {
        body = new StringBuilder();
    }

    public void appendToBody(String content) {
        body.append(content);
    }

    public String getBody() {
        return body.toString();
    }
}
