public abstract class Day {
    private final String NAME;

    protected Day(String name) {
        this.NAME = name;
    }

    protected String getName(){
        return NAME;
    }

    public void execute(){
        System.out.println("--- Part one ---");
        partOne();

        System.out.println("--- Part two ---");
        partTwo();
    }

    public abstract void partOne();

    public abstract void partTwo();
}
