public class CylinderTest {
    public static void main(String[] args) {
        // Create a cylinder with radius 5 and height 10
        Cylinder cylinder = new Cylinder(5, 10);
        
        System.out.println("=== Initial Cylinder Properties ===");
        System.out.println("Radius: " + cylinder.getRadius());
        System.out.println("Height: " + cylinder.getHeight());
        System.out.println("Volume: " + String.format("%.2f", cylinder.calculateVolume()));
        System.out.println("Surface Area: " + String.format("%.2f", cylinder.calculateSurfaceArea()));
        System.out.println("Lateral Surface Area: " + String.format("%.2f", cylinder.calculateLateralSurfaceArea()));
        
        // Use setters to change values
        System.out.println("\n=== Using Setters to Update Values ===");
        cylinder.setRadius(7);
        cylinder.setHeight(15);
        
        System.out.println("Updated Radius: " + cylinder.getRadius());
        System.out.println("Updated Height: " + cylinder.getHeight());
        System.out.println("New Volume: " + String.format("%.2f", cylinder.calculateVolume()));
        System.out.println("New Surface Area: " + String.format("%.2f", cylinder.calculateSurfaceArea()));
        System.out.println("New Lateral Surface Area: " + String.format("%.2f", cylinder.calculateLateralSurfaceArea()));
        
        // Test with invalid values
        System.out.println("\n=== Testing Invalid Values ===");
        cylinder.setRadius(-5);
        cylinder.setHeight(-10);
    }
}
