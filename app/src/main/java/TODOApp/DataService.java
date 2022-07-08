package TODOApp;

interface DataService {
    void initialize();
    void createItem(Item item);
    void modifyItem(int index, Item item);
    void deleteItem(int index);
    void toogleItem(int index);
    void showItem();
}