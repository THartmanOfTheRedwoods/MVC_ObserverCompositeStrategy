public class Main {
    public static void main(String[] args) {
        Router router = new Router();
        System.out.println("JSON Request");
        HttpRequest request = new HttpRequest("application/json");
        HttpResponse response = new HttpResponse();

        router.routeRequest(request, response);
        System.out.println(response.getBody());

        System.out.println("---");

        System.out.println("HTML Request");
        request = new HttpRequest("text/html");
        response = new HttpResponse();

        router.routeRequest(request, response);
        System.out.println(response.getBody());
    }
}