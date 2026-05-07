import com.sun.net.httpserver.HttpExchange;

public class HttpRequest {
    private final HttpExchange exchange;

    public HttpRequest(HttpExchange exchange) {
        this.exchange = exchange;
    }

    public String getHeader(String name) {
        // getFirst() handles the case where a header is absent, returning null
        return exchange.getRequestHeaders().getFirst(name);
    }
}