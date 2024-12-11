public class JSONViewStrategy implements ViewStrategy {
    @Override
    public void renderLeaf(String content, HttpResponse response) {
        if(!response.getBody().endsWith("[")) {
            response.appendToBody(",");
        }
        response.appendToBody("\"" + content + "\"");
    }

    @Override
    public void renderCompositeStart(HttpResponse response) {
        response.appendToBody("{ \"children\": [");
    }

    @Override
    public void renderCompositeEnd(HttpResponse response) {
        response.appendToBody("] }");
    }
}
