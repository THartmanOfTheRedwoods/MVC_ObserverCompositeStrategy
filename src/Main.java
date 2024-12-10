public class Main {
    public static void main(String[] args) {
        Router router = new Router();
        HttpRequest request = new HttpRequest("application/json");
        HttpResponse response = new HttpResponse();

        router.routeRequest(request, response);
        System.out.println(response.getBody());
    }
}