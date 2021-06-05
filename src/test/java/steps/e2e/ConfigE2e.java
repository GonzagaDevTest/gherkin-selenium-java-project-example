package steps.e2e;

import robo.Robo;
import steps.SetupClass;

public class ConfigE2e implements SetupClass {
    protected static Robo robo = new Robo();

    @Override
    public void setup() {
        if(Robo.getDriver() == null){
            robo.iniciarAutomacao();
        }
    }
}
