package org.ghosttrio;

public class ResourceTest implements AutoCloseable {

    private String name;

    public ResourceTest(String name) {
        this.name = name;
        System.out.println(name + " 자원이 열렸습니다.");
    }

    @Override
    public void close() {
        System.out.println(name + " 자원이 닫혔습니다.");
    }
    
    public void execute() {
        System.out.println("실행");
    }

    public static void main(String[] args) {
        try (ResourceTest r1 = new ResourceTest("Res1");
             ResourceTest r2 = new ResourceTest("Res2")) {
            r1.execute();
            r2.execute();
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}