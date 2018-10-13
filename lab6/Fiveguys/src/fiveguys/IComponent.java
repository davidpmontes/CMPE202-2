package fiveguys;

public interface IComponent {

    String getDescription();

    Double getPrice();

    void addSubComponent(IComponent component);

    IComponent getSubComponent();

}
