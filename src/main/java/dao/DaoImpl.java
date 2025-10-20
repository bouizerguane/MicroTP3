package dao;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dao")
@Primary

//@Profile("prod")
public class DaoImpl implements IDao {

    @Override
    public double getValue() {
        System.out.println("Version de production");
        return 100;
    }
}
