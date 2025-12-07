package app.coding.codingstuttle.tasks;


public class BakeCake {

    private Frosting frosting;
    private Syrup syrup;

    public BakeCake(Frosting frosting, Syrup syrup){
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake(){
        System.out.println("Bake the cake with " + this.frosting + " and " + this.syrup );
    }

    public void run(String... args) throws Exception {

       BakeCake bakeCake = new BakeCake(frosting, syrup);
       bakeCake.bakeCake();
    }
}
