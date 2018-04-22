import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        NearbyElements nearbyElements = new NearbyElements();
        System.out.println(Arrays.toString(nearbyElements.nearby(0,2,2)));
        System.out.println(Arrays.toString(nearbyElements.nearby(1,0,1)));
        System.out.println(Arrays.toString(nearbyElements.nearby(1,3,5)));
    }
}
