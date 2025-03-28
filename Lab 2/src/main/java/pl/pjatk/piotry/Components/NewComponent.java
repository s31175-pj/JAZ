package pl.pjatk.piotry.Components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class NewComponent {
    @Autowired private ApplicationContext applicationContext;

    public NewComponent(ApplicationContext applicationContext) {
        TestComponent testComponent = applicationContext.getBean(TestComponent.class);
        CheckComponent checkComponent = applicationContext.getBean(CheckComponent.class);

        testComponent.nazwy();
        checkComponent.nazwy();
        Object object = applicationContext.getBean("pojo");
        Object init = applicationContext.getBean("initBean");
        System.out.println(init.toString());
    }

}
