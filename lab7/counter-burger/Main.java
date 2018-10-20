public class Main {

    public static void main(String[] args) {
        IComposite theOrder = BuildOrder.getOrder();
        System.out.println(theOrder.getDescription());

    }
}
