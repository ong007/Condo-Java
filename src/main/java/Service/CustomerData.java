package Service;

import Model.BucketCustomer;
import Model.CustomerReader;

import java.io.*;

public class CustomerData {
    private String fileDirectoryName1;
    private String fileName;
    private BucketCustomer consumerList;

    public CustomerData(String fileDirectoryName1, String fileName1) {
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
            CustomerReader consumer = new CustomerReader(data[0], data[1], data[2], data[3], data[4], data[5], data[6],data[7]);
            consumerList.add(consumer);
        }
        reader.close();
    }

    public BucketCustomer getConsumerList() {
        try {
            consumerList = new BucketCustomer();
            readData();
        } catch (FileNotFoundException e) {
            System.err.println(this.fileName + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileName);
        }
        return consumerList;
    }
    public void setConsumerList(BucketCustomer consumerList) {
        String filePath = fileDirectoryName1 + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (CustomerReader consumer:consumerList.getBucketCustomer()) {
                String line = consumer.getName()+","+consumer.getSurname()+","+consumer.getRoom()+","+consumer.getFloor()+","+consumer.getBuilding()+","+(consumer.getBuilding()+consumer.getFloor()+consumer.getRoom())+","+consumer.getUsername()+","+consumer.getPassword();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
