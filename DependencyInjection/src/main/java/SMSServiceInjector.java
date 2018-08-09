import interfaces.Consumer;
import interfaces.MessageServiceInjector;

public class SMSServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new MyApplication(new SMSServiceImpl());
    }
}