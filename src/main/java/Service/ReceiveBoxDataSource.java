package Service;

import Model.ReceiveBoxReader;

import java.io.*;

public class ReceiveBoxDataSource {
    private String fileDirectoryNamebox;
    private String fileNamebox;
    private ReceiveBoxReader receiveboxlist;

    public ReceiveBoxDataSource(String fileDirectoryNamebox, String fileNamebox) {
        this.fileDirectoryNamebox = fileDirectoryNamebox;
        this.fileNamebox = fileNamebox;
        checkFileIsExisted();
    }

    private void checkFileIsExisted() {
        File file = new File(fileDirectoryNamebox);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = fileDirectoryNamebox + File.separator + fileNamebox;
        file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Cannot create " + filePath);
            }
        }
    }

    private void readData() throws IOException
    {
        String filePath = fileDirectoryNamebox + File.separator + fileNamebox;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            ReceiveBoxReader box= new ReceiveBoxReader(data[0], data[1], data[2], data[3], data[4],data[5],data[6],data[7],data[8]);

            receiveboxlist.add(box);
        }
        reader.close();
    }

    public ReceiveBoxReader getReceiveboxlist() {
        try {
           receiveboxlist = new ReceiveBoxReader();
            readData();
        } catch (FileNotFoundException e) {
            System.err.println(this.fileNamebox + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileNamebox);
        }
        return receiveboxlist;
    }
    public void setlist(ReceiveBoxReader maillist) {
        String filePath = fileDirectoryNamebox + File.separator + fileNamebox;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (ReceiveBoxReader box:maillist.getUserListBox())
            {
                String line = box.getSender()+","+box.getUsername()+","+box.getCompany()+","+box.getRoomnum()+","+box.getLevel()+","+box.getSize()+","+box.getTracking()+","+box.getTime()+","+box.getNameofficer();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
