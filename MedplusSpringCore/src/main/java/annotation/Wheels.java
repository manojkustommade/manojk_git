package annotation;

public interface Wheels {
    void rotate(String wheelType);
    default void material() {
    	System.out.println("Material are used for wheels is rubber...");
    }
}
