package TODOApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CSVFileManager implements DataService {
    private static String path = System.getProperty("user.dir");
	final static public String FILE_NAME =  path + "/OUTPUT/DATA/TodolistData.csv";
    private File csv = new File(FILE_NAME);
    private ArrayList<Item> itemList;

    public void initialize() {
		BufferedReader br = null;
		String line = "";
        List<String> csvList = new ArrayList<String>();

		try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                csvList.add(line);
            }
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
		    	if (br != null) {
					br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

        itemList = new ArrayList<>();
        for (int i = 0; i < csvList.size(); i++) {
            String getDataStr =  csvList.get(i);
            String[] dataString = getDataStr.split(",");
            itemList.add(new Item(dataString[0], dataString[1]));
        }
    }

    public void createItem(Item item) {
        itemList.add(item);
        restoreCSV();
    }

    public void modifyItem(int index, Item item) {
        itemList.set(index, item);
        restoreCSV();
    }

    public void deleteItem(int index) {
        if (index == 0) {
            itemList.clear();
        } else if (index <= itemList.size()) {
            index -= 1;
            itemList.remove(index);
        }
        restoreCSV();
    }

    public void toogleItem(int index) {
        if (itemList.get(index).getStatus().equals("N")) {
            itemList.get(index).setStatus("Y");
        } else {
            itemList.get(index).setStatus("N");
        }
        restoreCSV();
    }

    public void showItem() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("--------------------------------------------\n" +
                            "index            todo                status\n" +
                            "--------------------------------------------\n");
        for(int i = 0; i < itemList.size(); i++){
            stringBuilder.append("   ");
            stringBuilder.append(i+1);
            stringBuilder.append("            ");
            stringBuilder.append(itemList.get(i).getTodo() + "");
            stringBuilder.append("            ");
            stringBuilder.append(itemList.get(i).getStatus() + "\n");
        }
        stringBuilder.append("--------------------------------------------\n");

        System.out.println(stringBuilder.toString());
    }


    private void restoreCSV() {
		BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(csv, false));
            for (int i = 0; i < itemList.size(); i++) {
                bw.write(itemList.get(i).getTodo() + "," + itemList.get(i).getStatus());
                bw.newLine();
            }
        }
         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
