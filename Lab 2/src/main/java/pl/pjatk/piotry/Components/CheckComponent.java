package pl.pjatk.piotry.Components;

import org.springframework.stereotype.Component;

@Component
public class CheckComponent {
    TestComponent testComponent;
    public CheckComponent(TestComponent testComponent) {
        this.testComponent = testComponent;


    }

    public void nazwy() {
        System.out.println("komponent: checkComponent");
        System.out.println("metoda: nazwy");
    }
}
