package TODOApp;

class DBConnectionManager implements DataService {

	@Override
	public void initialize() {
        System.out.println("initalize file...");
	}

    @Override
    public void createItem(Item item) {
        System.out.println("create Item ...");
    }

    @Override
    public void modifyItem(int index, Item item) {
        System.out.println("modify Item ...");
    }

    @Override
    public void deleteItem(int index) {
        System.out.println("delete Item...");
    }

    @Override
    public void toogleItem(int index) {
        System.out.println("toogle Item...");
    }

    @Override
    public void showItem() {
        System.out.println("print item...");
    }
}
