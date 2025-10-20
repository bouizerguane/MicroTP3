package dao;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dao2")
@Primary
//@Profile("dev")
public class DaoImpl2 implements IDao{

    @Override
    public double getValue() {
        System.out.println("Version de développement");
        return 200;
    }
}
