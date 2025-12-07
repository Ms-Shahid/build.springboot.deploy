package app.coding.codingstuttle.tasks;

import org.springframework.stereotype.Component;

@Component
public class Strawberry implements Syrup{

    @Override
    public void getSyrupType() {
        System.out.println(" type : Strawberry");
    }
}
