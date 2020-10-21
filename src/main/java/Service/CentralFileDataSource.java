package Service;

import Model.Centraluserreader;

import java.io.*;

public class CentralFileDataSource {
    private String fileDirectoryName;
    private String fileName;
    private Centraluserreader centralList;

    public CentralFileDataSource(String fileDirectoryName, String fileName) {
        this.fileDirectoryName = fileDirectoryName;
        this.fileName = fileName;
        checkFileIsExisted();
    }

    private void checkFileIsExisted() {
        File file = new File(fileDirectoryName);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = fileDirectoryName + File.separator + fileName;
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
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            Centraluserreader central = new Centraluserreader(data[0], data[1], data[2], data[3], data[4], data[5],data[6],data[7],Integer.parseInt(data[8]));
            centralList.add(central);
        }
        reader.close();
    }

    public Centraluserreader getCentralList() {
        try {
            centralList = new Centraluserreader();
            readData();
        } catch (FileNotFoundException e) {
            System.err.println(this.fileName + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileName);
        }
        return centralList;
    }
    public void setCentralList(Centraluserreader centrals) {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Centraluserreader central:centrals.getUserList()) {
                String line = central.getName()+","+central.getSurname()+","+central.getTel()+","+central.getEmail()+","+central.getUsername()+","+central.getPassword()+","+central.getTime()+","+central.getStatus()+","+central.getAttempt();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
