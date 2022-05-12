package school21.spring.service.repositories.printer;

import school21.spring.service.repositories.renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer {

    private Renderer renderer;
    private String prefix;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void print(String message) {
        renderer.outputMessage(prefix + " " + message);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}
