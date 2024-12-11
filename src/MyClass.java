public class MyClass {

    @AutoInjectable
    private SomeService someService;

    public void doSomething() {
        someService.execute();
    }
}
