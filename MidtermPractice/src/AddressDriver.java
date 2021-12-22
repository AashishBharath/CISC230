
public class AddressDriver {

    public static void main(String[] args) {
        Address addy = new Address(14420, "Atwater Way", "Rosemount", "MN", 55068);
        Address addy2 = new Address(14420, "Atwater Way", "Rosemount", "MN", 55069);

        System.out.println(addy.nearby(addy2));
        System.out.println(addy);
    }

}
