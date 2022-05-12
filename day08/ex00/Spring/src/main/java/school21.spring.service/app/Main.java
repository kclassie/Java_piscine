package school21.spring.service.app;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.repositories.preprocessor.PreProcessor;
import school21.spring.service.repositories.preprocessor.PreProcessorToUpperImpl;
import school21.spring.service.repositories.printer.Printer;
import school21.spring.service.repositories.printer.PrinterWithPrefixImpl;
import school21.spring.service.repositories.renderer.Renderer;
import school21.spring.service.repositories.renderer.RendererErrImpl;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context;
        try {
            context = new ClassPathXmlApplicationContext("context.xml");
            Printer printer = context.getBean("printerWithPrefixToUpperStd", Printer.class);
            printer.print("Hello!");
            ((ClassPathXmlApplicationContext) context).close();
        } catch (BeanCreationException e) {
            e.printStackTrace();
        }
    }

}
