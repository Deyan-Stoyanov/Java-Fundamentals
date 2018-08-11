package models.engines;

public class JetEngine extends BaseEngine
{
    private static final int MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        if (this.cachedOutput != 0)
        {
            return this.cachedOutput;
        }

        this.cachedOutput = (this.getHorsepower() * MULTIPLIER) + this.getDisplacement();
        return this.cachedOutput;
    }
}
