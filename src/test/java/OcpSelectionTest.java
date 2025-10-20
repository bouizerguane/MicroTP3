import metier.IMetier;
import presentation.Presentation;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.AssertJUnit;


public class OcpSelectionTest {

    @org.junit.jupiter.api.Test
    public void devProfile_choisitDao2_300() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");     // DaoImpl2 (150)
        ctx.register(Presentation.class);
        ctx.refresh();
        IMetier m = ctx.getBean(IMetier.class);
        AssertJUnit.assertEquals(300.0, m.calcul(), 1e-6);
        ctx.close();
    }

    @Test
    public void prodProfile_choisitDao_200() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");    // DaoImpl (100)
        ctx.register(Presentation.class);
        ctx.refresh();
        IMetier m = ctx.getBean(IMetier.class);
        AssertJUnit.assertEquals(200.0, m.calcul(), 1e-6);
        ctx.close();
    }
}