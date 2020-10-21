package Service;

import Model.Consumerreader;
import Model.Roomreader;

import java.io.*;

public class Roomdatasource {
    private String fileDirectoryName1;
    private String fileName;
    private Roomreader roomlist;

    public Roomdatasource(String fileDirectoryName1, String fileName1) {
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
            Roomreader room = new Roomreader(data[0], data[1], data[2], data[3]);
            roomlist.add(room);
        }
        reader.close();
    }

    public Roomreader getRoomlist() {
        try {
            roomlist = new Roomreader();
            readData();
        } catch (FileNotFoundException e) {
            System.err.println(this.fileName + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileName);
        }
        return roomlist;
    }
    public void setRoomlist(Roomreader roomlist) {
        String filePath = fileDirectoryName1 + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Roomreader room:roomlist.getUserList()) {
                String line = room.getBuilding()+","+room.getType()+","+room.getFloor()+","+room.getRoom();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
