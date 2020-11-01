package Service;

import Model.Box;

import java.io.*;

public class BoxData {

        private String fileDirectoryNamebox;
        private String fileNamebox;
        private Box boxlist;

        public BoxData(String fileDirectoryNamebox, String fileNamebox) {
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
                Box box = new Box(data[0], data[1], data[2], data[3], data[4], data[5],data[6],data[7]);
                boxlist.add(box);
            }
            reader.close();
        }

        public Box getBoxlist() {
            try {
                boxlist = new Box();
                readData();
            } catch (FileNotFoundException e) {
                System.err.println(this.fileNamebox + " not found");
            } catch (IOException e) {
                System.err.println("IOException from reading " + this.fileNamebox);
            }
            return boxlist;
        }
        public void setBoxlist(Box boxlist) {
            String filePath = fileDirectoryNamebox + File.separator + fileNamebox;
            File file = new File(filePath);
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(fileWriter);
                for (Box box:boxlist.getUserList()) {
                    String line = box.getUsername()+","+box.getSender()+","+box.getSize()+","+box.getCompany()+","+box.getRoomnum()+","+box.getTime()+","+box.getLevel()+","+box.getTacking();
                    writer.append(line);
                    writer.newLine();
                }
                writer.close();
            } catch (IOException e) {
                System.err.println("Cannot write " + filePath);
            }
        }
    }


