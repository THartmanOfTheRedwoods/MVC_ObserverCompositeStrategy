import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", exchange -> {
            Router router = new Router();
            router.routeRequest(exchange);
        });

        server.start();
        System.out.println("Server running on http://localhost:" + port);
        System.out.println("Try: curl -H 'Accept: application/json' http://localhost:8080/");
        System.out.println("Try: curl http://localhost:8080/");
    }
}