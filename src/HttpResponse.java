import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HttpResponse {
    private final HttpExchange exchange;
    private final StringBuilder body = new StringBuilder();
    private String contentType = "text/html; charset=UTF-8";

    public HttpResponse(HttpExchange exchange) {
        this.exchange = exchange;
    }

    public void appendToBody(String content) {
        body.append(content);
    }

    public String getBody() {
        return body.toString();
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /** Flushes the buffered body to the real HTTP response and closes the stream. */
    public void send() throws IOException {
        byte[] bytes = body.toString().getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", contentType);
        exchange.sendResponseHeaders(200, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}