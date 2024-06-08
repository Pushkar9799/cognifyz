import java.util.*;
//bill of items
public class Bill_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float Pencil = sc.nextFloat();
        float Pen = sc.nextFloat();
        float Eraser = sc.nextFloat();
        float Total = Pencil + Pen + Eraser;
        System.out.println(Total);

        //with 18% gst

        float Newtotal = Total + (0.18f * Total);
        System.out.println(Newtotal);
    }
}




