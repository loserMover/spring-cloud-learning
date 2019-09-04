import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(EventConfiguration.class);
        applicationContext.register(MyApplicationListener.class);
        applicationContext.refresh();

        applicationContext.publishEvent(new MyApplicationEvent("hello world"));

    }

    public static class MyApplicationEvent extends ApplicationEvent{
        public MyApplicationEvent(String source) {
            super(source);
        }
    }

    @Configuration
    public static class EventConfiguration{
        @EventListener
        public void onMessage(MyApplicationEvent event){
            System.out.println("监听事件："+event);
        }
    }

    public static class MyApplicationListener implements ApplicationListener<MyApplicationEvent>{
        @Override
        public void onApplicationEvent(MyApplicationEvent event) {
            System.out.println("ApplicationListener监听事件："+event);
        }
    }



}
