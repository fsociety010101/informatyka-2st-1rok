package adapter;

public class CityLightsWrapper {

    private LegacyCityLights legacyCityLights;
    private Boolean lightsAreTurnedON = false;

    CityLightsWrapper(LegacyCityLights legacyCityLights) {
        this.legacyCityLights = legacyCityLights;
    }

    public void turnOnAllLigths(){
        this.legacyCityLights.turnOnLampsInFrontOfTheCityCouncil();
        this.legacyCityLights.turnOnLampsInFrontOfTheLibrary();
        this.legacyCityLights.turnOnLampsInFrontOfThePoliceStation();
        this.legacyCityLights.turnOnLampsInFrontOfTheTrainStation();
        this.lightsAreTurnedON = true;
    }

    public void turnOffAllLights(){
        this.legacyCityLights.turnOffLampsInFrontOfTheCityCouncil();
        this.legacyCityLights.turnOffLampsInFrontOfTheLibrary();
        this.legacyCityLights.turnOffLampsInFrontOfThePoliceStation();
        this.legacyCityLights.turnOffLampsInFrontOfTheTrainStation();
        this.lightsAreTurnedON = false;
    }

    public Boolean getLightsAreTurnedON() {
        return lightsAreTurnedON;
    }

}
