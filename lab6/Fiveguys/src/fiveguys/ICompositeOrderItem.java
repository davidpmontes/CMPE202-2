package fiveguys;

/**
 * IComposite
 */
public interface ICompositeOrderItem extends IOrderItem{

    void addChild(ICompositeOrderItem composition);

    ICompositeOrderItem getChild();

}
