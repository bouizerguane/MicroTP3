package dao;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("dao")
@Profile("file")
public class DaoFile implements IDao {

    @Override
    public double getValue() {
        System.out.println("Version de production");
        return 180;
    }
}
