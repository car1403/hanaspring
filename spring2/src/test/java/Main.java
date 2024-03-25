import com.hana.app.data.CustDto;
import com.hana.app.exception.DuplicatedIdException;
import com.hana.app.frame.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");

        Service<String, CustDto> service =
                (Service<String, CustDto>) factory.getBean("custService");

        CustDto u = new CustDto("id02", "pwd02", "lee");
        try {
            service.add(u);
        } catch (DuplicatedIdException e) {
            throw new RuntimeException(e);
        }


    }
}