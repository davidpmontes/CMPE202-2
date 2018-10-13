package fiveguys;

public interface IPrintStrategy {

    default String printOrder(Order order) {
        StringBuilder out = new StringBuilder();
        out.append(printHeader());
        out.append(printDetail(order));
        out.append(printFooter());
        return out.toString();
    };

    default StringBuilder printHeader() {return null;}

    StringBuilder printDetail(Order order);

    default StringBuilder printFooter() {return null;}

}
