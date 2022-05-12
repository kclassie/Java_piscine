package school21.spring.service.repositories.preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {

    public PreProcessorToUpperImpl() {
    }

    @Override
    public String convertMessage(String message) {
        return (message.toUpperCase());
    }
}
