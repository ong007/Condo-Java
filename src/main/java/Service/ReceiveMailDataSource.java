package Service;

import Model.ReceiveBoxReader;
import Model.ReceiveMailReader;

import java.io.*;

public class ReceiveMailDataSource {
    private String fileDirectoryNamebox;
    private String fileNamebox;
    private ReceiveMailReader receivemaillist;

    public ReceiveMailDataSource(String fileDirectoryNamebox, String fileNamebox) {
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

    private void readData() throws IOException {
        String filePath = fileDirectoryNamebox + File.separator + fileNamebox;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            ReceiveMailReader mail= new ReceiveMailReader(data[0], data[1], data[2], data[3], data[4],data[5],data[6]);
            receivemaillist.add(mail);
        }
        reader.close();
    }

    public ReceiveMailReader getReceiveboxlist() {
        try {
            receivemaillist = new ReceiveMailReader();
            readData();
        } catch (FileNotFoundException e) {
            System.err.println(this.fileNamebox + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileNamebox);
        }
        return receivemaillist;
    }
    public void setMaillist(ReceiveMailReader maillist) {
        String filePath = fileDirectoryNamebox + File.separator + fileNamebox;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (ReceiveMailReader mail:receivemaillist.getUserList1()) {
                String line = mail.getSender()+","+mail.getUsername()+","+mail.getCompany()+","+mail.getRoomnum()+","+mail.getSize()+","+mail.getTime()+","+mail.getNameofficer();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
