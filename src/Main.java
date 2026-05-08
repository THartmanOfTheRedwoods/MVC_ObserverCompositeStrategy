import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        Router router = new Router();
        router.register("/", new HomeHandler());
        router.register("/users", new UsersHandler());
        // router.register("/products", new ProductsHandler()); // adding routes stays this simple

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> router.routeRequest(exchange));
        server.start();

        System.out.println("Server running on http://localhost:8080");
        System.out.println("curl http://localhost:8080/");
        System.out.println("curl -H 'Accept: application/json' http://localhost:8080/users");
    }
}