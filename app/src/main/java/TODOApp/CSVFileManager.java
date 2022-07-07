package TODOApp;

import java.io.*;
import java.util.*;

public class CSVFileManager implements DataService {

	final static public String FILE_NAME =  "./data/TodolistData.csv";
    ArrayList<Item> itemList;

    public void initialize() {
        File csv = new File(FILE_NAME);
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
        File csv = new File(FILE_NAME);
		BufferedWriter bw = null;

        itemList.add(item);

        try {
            int lastIdx = itemList.size() - 1;
            bw = new BufferedWriter(new FileWriter(csv, true));
            String line = itemList.get(lastIdx).getTodo() + "," + itemList.get(lastIdx).getStatus();
            bw.write(line);
            bw.newLine();
        } catch(FileNotFoundException e) {
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

    public void modifyItem(int index, Item item) {
        File csv = new File(FILE_NAME);
		BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(csv, false));
            itemList.set(index, item);
            for (int i = 0; i < itemList.size(); i++) {
                bw.write(itemList.get(i).getTodo() + "," + itemList.get(i).getStatus());
                bw.newLine();
            }
        } catch(FileNotFoundException e) {
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

    public void deleteItem(int index) {
        File csv = new File(FILE_NAME);
		BufferedWriter bw = null;

        if (index == 0) {
            itemList.clear();
            try {
                bw = new BufferedWriter(new FileWriter(csv, false));
                bw.flush();
            } catch (FileNotFoundException e) {
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
        } else if (index <= itemList.size()) {
            index -= 1;
            itemList.remove(index);
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

    public void toogleItem(int index) {
        if (itemList.get(index).getStatus().equals("N")) {
            itemList.get(index).setStatus("Y");
        } else {
            itemList.get(index).setStatus("N");
        }

        File csv = new File(FILE_NAME);
		BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(csv, false));
            for (int i = 0; i < itemList.size(); i++) {
                bw.write(itemList.get(i).getTodo() + "," + itemList.get(i).getStatus());
                bw.newLine();
            }
        } catch(FileNotFoundException e) {
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
}
