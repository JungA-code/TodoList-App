package TODOApp;

public interface DataService {
    public void initialize();
    public void createItem(Item item);
    public void modifyItem(int index, Item item);
    public void deleteItem(int index);
    public void toogleItem(int index);
    public void showItem();
}
