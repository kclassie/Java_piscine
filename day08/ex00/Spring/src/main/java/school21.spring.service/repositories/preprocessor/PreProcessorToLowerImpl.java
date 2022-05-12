package school21.spring.service.repositories.preprocessor;

public class PreProcessorToLowerImpl implements PreProcessor {

   public PreProcessorToLowerImpl() {
   }

   @Override
   public String convertMessage(String message) {
      return (message.toLowerCase());
   }
}
