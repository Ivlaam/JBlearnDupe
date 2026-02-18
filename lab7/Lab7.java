package lab7;

public class Lab7 {
    public static void main(String[] args) {
        Plane boeing = new Plane("Boeing 747");
        Plane airbus = new Plane("Airbus A320");

        Plane.Wing leftWing = boeing.new Wing();
        Plane.Wing rightWing = airbus.new Wing();

        leftWing.setWeight(1500.5);
        rightWing.setWeight(1200.0);

        System.out.println("Самолет: " + boeing.getModel());
        leftWing.showWeight();

        System.out.println("\nСамолет: " + airbus.getModel());
        rightWing.showWeight();
    }
}

class Plane {
    private String model;

    public Plane(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    class Wing {
        private double wingWeight;

        public void setWeight(double weight) {
            this.wingWeight = weight;
        }

        public void showWeight() {
            System.out.println("Вес крыла составляет: " + wingWeight + " кг.");
        }
    }
}