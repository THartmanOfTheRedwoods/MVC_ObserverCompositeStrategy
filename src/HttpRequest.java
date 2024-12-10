import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private Map<String, String> headers;

    public HttpRequest(String acceptHeader) {
        headers = new HashMap<>();
        headers.put("Accept", acceptHeader);
    }

    public String getHeader(String name) {
        return headers.get(name);
    }
}
