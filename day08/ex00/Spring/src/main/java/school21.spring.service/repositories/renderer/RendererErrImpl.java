package school21.spring.service.repositories.renderer;

import school21.spring.service.repositories.preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {

    private PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    public void outputMessage(String message) {
        System.err.println((char)27 + "[31m" + preProcessor.convertMessage(message) + (char)27 + "[0m");
    }
}
