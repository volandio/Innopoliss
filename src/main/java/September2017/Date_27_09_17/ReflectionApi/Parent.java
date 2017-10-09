package September2017.Date_27_09_17.ReflectionApi;

public class Parent extends GrandFather {
    private int privateInt;
    public int publicInt;
    protected int protectedInt;

    private String prvateFunction(){
        return "private";
    }
    public String publicFunction(){
        return "public";
    }
    protected String protectedFunction(){
        return "protected";
    }
}
