package app.coding.codingstuttle.tasks;

import org.springframework.stereotype.Component;

@Component
public class Chocolate implements Frosting{

    @Override
    public void getFrostingType() {
        System.out.println(" type : Chocolate" );
    }
}
