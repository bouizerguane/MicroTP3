package presentation;


import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"dao", "metier", "config"})
public class Presentation {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // Choix 1 (profils) : décommenter un profil pour tester
        // context.getEnvironment().setActiveProfiles("dev");   // -> DaoImpl2 (200) => 400
        // context.getEnvironment().setActiveProfiles("prod");  // -> DaoImpl  (100) => 200
        // context.getEnvironment().setActiveProfiles("file");  // -> DaoFile  (180) => 360
        // context.getEnvironment().setActiveProfiles("api");   // -> DaoApi   (220) => 440

        // Choix 2 (propriété externe) : laisser les profils vides,
        // PropertyDrivenConfig créera un bean "dao" selon app.properties

        context.register(Presentation.class);
        context.refresh();

        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Résultat = " + metier.calcul());
        context.close();

    }
}
