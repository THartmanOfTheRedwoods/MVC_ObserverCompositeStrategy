import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class Router {
    private final Map<String, RouteHandler> routes = new LinkedHashMap<>();

    public void register(String path, RouteHandler handler) {
        routes.put(path, handler);
    }

    public void routeRequest(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        RouteHandler handler = routes.get(path);

        if (handler != null) {
            handler.handle(exchange);
        } else {
            byte[] body = ("404 Not Found: " + path).getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(404, body.length);
            exchange.getResponseBody().write(body);
            exchange.getResponseBody().close();
        }
    }
}