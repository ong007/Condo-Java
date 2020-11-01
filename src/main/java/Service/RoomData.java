package Service;

import Model.Room;

import java.io.*;

public class RoomData {
    private String fileDirectoryName1;
    private String fileName;
    private Room roomlist;

    public RoomData(String fileDirectoryName1, String fileName1) {
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
            Room room = new Room(data[0], data[1], data[2], data[3],data[4],Integer.parseInt(data[5]),Integer.parseInt(data[6]));
            roomlist.add(room);
        }
        reader.close();
    }

    public Room getRoomlist() {
        try {
            roomlist = new Room();
            readData();
        } catch (FileNotFoundException e) {
            System.err.println(this.fileName + " not found");
        } catch (IOException e) {
            System.err.println("IOException from reading " + this.fileName);
        }
        return roomlist;
    }
    public void setRoomlist(Room roomlist) {
        String filePath = fileDirectoryName1 + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Room room:roomlist.getUserList()) {
                String line = room.getBuilding()+","+room.getType()+","+room.getFloor()+","+room.getRoom()+","+(room.getBuilding()+room.getFloor()+room.getRoom())+","+room.getMaxarrival()+","+room.getNowarrival();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }
}
