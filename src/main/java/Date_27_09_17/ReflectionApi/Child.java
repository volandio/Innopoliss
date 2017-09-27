package Date_27_09_17.ReflectionApi;

public class Child extends Parent {
    private Long privateLong;
    public Long publicLong;
    protected Long protectedLong;

    private void privateProcedure(int iValue){
        System.out.println("param " + iValue);
    }
    public void publicProcedure(String sValue){

    }
    protected void protectedProcedure(int iValue, String sValue){

    }

    @Override
    public String publicFunction() {
        return super.publicFunction();
    }

    @Override
    protected String protectedFunction() {
        return super.protectedFunction();
    }
}
