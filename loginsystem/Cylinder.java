public class Cylinder {
    private double radius;
    private double height;
    
    // Constructor
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    
    // Setter for radius
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Radius must be positive");
        }
    }
    
    // Getter for radius
    public double getRadius() {
        return radius;
    }
    
    // Setter for height
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Height must be positive");
        }
    }
    
    // Getter for height
    public double getHeight() {
        return height;
    }
    
    // Calculate volume using radius and height
    public double calculateVolume() {
        return Math.PI * radius * radius * height;
    }
    
    // Calculate surface area using radius and height
    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
    
    // Calculate lateral surface area using radius and height
    public double calculateLateralSurfaceArea() {
        return 2 * Math.PI * radius * height;
    }
}
