package October2017.Date_17_10_17.patternFactory.MotoBuilder;

public class MotoBuilder {

    public Moto build(String modalName){
       return new Moto(MotoWiki.getPowerByName(modalName),
               MotoWiki.getCapacityByName(modalName),
               MotoWiki.getSpeedByName(modalName),
               modalName);
    }

}
