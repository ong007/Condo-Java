package Service;

import Model.Box;
import Model.BucketItem;
import Model.Item;

import java.io.*;

public class BoxData {

        private String fileDirectoryNamebox;
        private String fileNamebox;
        private BucketItem boxlist;

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
                boxlist.addItem(box);
            }
            reader.close();
        }

        public BucketItem getBoxlist() {
            try {
                boxlist = new BucketItem();
                readData();
            } catch (FileNotFoundException e) {
                System.err.println(this.fileNamebox + " not found");
            } catch (IOException e) {
                System.err.println("IOException from reading " + this.fileNamebox);
            }
            return boxlist;
        }
        public void setBoxlist(BucketItem boxlist) {
            String filePath = fileDirectoryNamebox + File.separator + fileNamebox;
            File file = new File(filePath);
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(fileWriter);
                for (Item box:boxlist.getBucketItem()) {
                    if (box instanceof Box){
                    String line = box.getUsername()+","+box.getSender()+","+box.getSize()+","+box.getCompany()+","+box.getRoomnum()+","+box.getTime()+","+ ((Box) box).getLevel()+","+ ((Box) box).getTacking();
                    writer.append(line);
                    writer.newLine();}
                }
                writer.close();
            } catch (IOException e) {
                System.err.println("Cannot write " + filePath);
            }
        }
    }


