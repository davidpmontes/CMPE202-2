
public interface IComposite {

    String getDescription();

    void addChild(IComposite c);

    void removeChild(IComposite c);

    IComposite getChild(int i);

}
