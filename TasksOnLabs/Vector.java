public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double get_x() {
        return x;
    }
    
    public void set_x(double x) {
        this.x = x;
    }

    public double get_y() {
        return y;
    }
    
    public void set_y(double y) {
        this.y = y;
    }

    public double get_z() {
        return z;
    }
    
    public void set_z(double z) {
        this.z = z;
    }

    public Vector sum_vectors(Vector other) {
        Vector v = new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
        return v;
    }

    public double scalar(Vector other) {
        return (this.x * other.x + this.y * other.y + this.z * other.z);
    }

    public Vector multipl(double num) {
        Vector v = new Vector(num * this.x, num * this.y, num * this.z);
        return v;
    }

    public static void main(String[] args) {
        Vector v1 = new Vector(2.0, 3.0, 4.0);
        Vector v2 = new Vector(6.0, 1.0, 1.0);
        Vector v3 = v1.sum_vectors(v2);
        Vector v4 = v2.multipl(4.0);
        System.out.print(v4.x + "\n" + v4.y + "\n" + v4.z + "\n");
        System.out.print(v1.scalar(v3) + "\n");
        System.out.print(v1.scalar(v2) + "\n");
    }
}