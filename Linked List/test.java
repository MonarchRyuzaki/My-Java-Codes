public class test {
    static class Info{
        double t2;
        double phi;
        double t1;
        Info(double t2,double phi,double t1){
            this.t2 = t2;
            this.phi = phi;
            this.t1 = t1;
        }
    }
    public static Info getInfo(double x1, double y1, double l1, double l2){
        double cos_t2 = 0.0;
        cos_t2 =((x1*x1) + (y1*y1) - ((l1*l1)+(l2*l2)))/(2*l1*l2);
        double t2 = Math.acos(cos_t2);
        double phi = Math.atan(y1/x1);
        double t1 = phi-t2;
        return new Info(t2,phi,t1);
    }
    public static void main(String[] args) {
        Info info = getInfo(2, 3, 3, 1);
        System.out.println(info.t2 +" "+ info.phi+" "+info.t1);
    }
}