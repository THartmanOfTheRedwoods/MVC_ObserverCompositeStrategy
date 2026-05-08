public class JSONViewStrategy implements ViewStrategy {

    @Override
    public void renderLeaf(String content, HttpResponse response) {
        if (!response.getBody().endsWith("[")) {
            response.appendToBody(", ");
        }
        response.appendToBody("\"" + content + "\"");
    }

    @Override
    public void renderCompositeStart(Component component, HttpResponse response) {
        // A nested Composite is a sibling value just like a Leaf —
        // it needs the same comma guard when it follows another value.
        String body = response.getBody();
        if (!body.isEmpty() && !body.endsWith("[")) {
            response.appendToBody(", ");
        }
        String c_name = component.getName();
        String output = String.format(
                "{%s\"children\": [",
                (!c_name.isEmpty()) ? String.format("\"type\": \"%s\", ", c_name) : " "
        );
        response.appendToBody(output);
    }

    @Override
    public void renderCompositeEnd(Component component, HttpResponse response) {
        response.appendToBody("] }");
    }
}