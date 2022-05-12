package school21.spring.service.repositories.printer;

import school21.spring.service.repositories.renderer.Renderer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrinterWithDateTimeImpl implements Printer {

    Renderer renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void print(String message) {
        renderer.outputMessage(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                + " " + message);
    }
}
