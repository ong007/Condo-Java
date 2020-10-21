package Service;

import Model.Consumerreader;

import java.io.*;

public class Consumerdatasource {
    private String fileDirectoryName1;
    private String fileName;
    private Consumerreader consumerList;

    public Consumerdatasource(String fileDirectoryName1, String fileName1) {
        this.fileDirectoryName1 = fileDirectoryName1;
        this.fileName = fileName1;
        checkFileIsExisted();
    }

    private void checkFileIsExisted() {
        File file = new File(fileDirectoryName1);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = fileDirectoryName1 + File.separator + fileName;
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
        String filePath = fileDirectoryName1 + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            Consumerreader consumer = new Consumerreader(data[0], data[1], data[2], data[3], data[4], data[5]);
            consumerList.add(consumer);
        }
        reader.close();
    }

    public Consumerreader getConsumerList() {
        try {
            consumerList = new Consumerreader();
            readData();
        } catch (FileNotFoundException e) {
            System.err.println(this.fileName + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileName);
        }
        return consumerList;
    }
    public void setConsumerList(Consumerreader consumerList) {
        String filePath = fileDirectoryName1 + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Consumerreader consumer:consumerList.getUserList()) {
                String line = consumer.getName()+","+consumer.getSurname()+","+consumer.getRoom()+","+consumer.getFloor()+","+consumer.getUsername()+","+consumer.getPassword();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
