package TODOApp;

import java.util.Scanner;

class CommandManager {
    private DataService dataService;

    protected CommandManager(DataService dataService) {
        this.dataService = dataService;
        dataService.initialize();
    }

    protected void inputCommand() {
        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("quit")) {
            System.out.println("1. create\t 2. modify\t 3. delete\t 4. show\t 5. toogle \t ?. help \t quit");

            System.out.print("command: ");
            command  = scanner.nextLine();
            System.out.println(command);
            switch (command) {
                case "1":
                    System.out.print("todo task: ");
                    String todoTask = scanner.nextLine();
                    createItemFunction(todoTask);
                    break;
                case "2":
                    System.out.print("Insert modify index: ");
                    String modifyIdx = scanner.nextLine();
                    System.out.println();
                    System.out.print("modify todo task: ");
                    String modifyTask = scanner.nextLine();
                    modifyItemFunction(Integer.parseInt(modifyIdx), modifyTask);
                    break;
                case "3":
                    System.out.print("Insert Delete index (if you remove all index, insert 0): ");
                    String delIdx = scanner.nextLine();
                    deleteItemFunction(Integer.parseInt(delIdx));
                    break;
                case "4":
                    showItemFunction();
                    break;
                case "5":
                    System.out.print("Insert toogle status index: ");
                    String toogleIdx = scanner.nextLine();
                    toogleItemFunction(Integer.parseInt(toogleIdx));
                    break;
                case "?":
                    commandPrintFunction();
                    break;
                default:
                    System.out.println("retry");
                    break;
            }
        }
        scanner.close();
    }

    private void commandPrintFunction() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("------------------------------------------\n" +
                                "command id         command\n" +
                                "------------------------------------------\n" +
                                "   1             create an item\n" +
                                "   2             modify an item\n" +
                                "   3             delete an item (or all - options: --all)\n" +
                                "   4             show items\n" +
                                "   5             toggle status of an item\n" +
                                "   quit          Program exit\n" +
                                "------------------------------------------");
        System.out.println(stringBuilder.toString());
    }

    private void createItemFunction(String todoTask) {
        dataService.createItem(new Item(todoTask));
    }

    private void modifyItemFunction(int modifyIdx, String  modifyTask) {
        modifyIdx--;
        dataService.modifyItem(modifyIdx, new Item(modifyTask));
    }

    private void showItemFunction() {
        dataService.showItem();
    }

    private void toogleItemFunction(int toogleIdx) {
        toogleIdx--;
        dataService.toogleItem(toogleIdx);
    }

    private void deleteItemFunction(int delIdx) {
        dataService.deleteItem(delIdx);
    }
}
