package Service;

import Model.BucketReceiveItem;
import Model.ReceiveBox;
import Model.ReceiveMail;
import Model.ReceiveText;

import java.io.*;

public class ReceiveTextData {
    private String fileDirectoryNamebox;
    private String fileNamebox;
    private BucketReceiveItem receivetextlist;

    public ReceiveTextData(String fileDirectoryNamebox, String fileNamebox) {
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
            ReceiveText text= new ReceiveText(data[0], data[1], data[2], data[3], data[4],data[5],data[6],data[7]);
            receivetextlist.addItem(text);
        }
        reader.close();
    }

    public BucketReceiveItem getReceiveTextlist() {
        try {
            receivetextlist = new BucketReceiveItem();
            readData();
        } catch (FileNotFoundException e) {
            System.err.println(this.fileNamebox + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileNamebox);
        }
        return receivetextlist;
    }
    public void setTextlist(BucketReceiveItem textlist) {
        String filePath = fileDirectoryNamebox + File.separator + fileNamebox;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (ReceiveMail text:receivetextlist.getBucketReceiveItem()) {
                if (text instanceof ReceiveText){
                String line = text.getSender()+","+text.getUsername()+","+text.getCompany()+","+text.getRoomnum()+","+ ((ReceiveText) text).getLevel()+","+text.getSize()+","+text.getTime()+","+text.getNameofficer();
                writer.append(line);
                writer.newLine();}
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
