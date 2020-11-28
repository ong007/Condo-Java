# 6210406572
ติดตั้ง FONT ก่อน

Condo Application  โปรเเกรมคอนโดสำหรับรับ-ส่งของภายในหอพัก เเละเพิ่มจำนวนห้องพร้อมลูกบ้านสำหรับเข้าพักอาศัย

  - วิธีติดตั้ง Program เเละ Run Program
  - Folder
  - การพัฒนาในเเต่ละสัปดาห์

# วิธีติดตั้ง Program เเละ Run Program

  - double click ที่ไฟล์ 6210406572.jar เพื่อเปิดโปรเเกรม
  - ถ้า double click ไม่ได้ให้คลิกขวา เเละ กด open powershell window here จากนั้นพิมคำสั่ง java -jar 6210406572.jar


### Folder

> data
* Text.csv  ---> เก็บข้อมูลต่างๆของเอกสารที่เข้ามาส่งในหอพัก
* Mail.csv  ---> เก็บข้อมูลต่างๆของจดหมายที่เข้ามาส่งในหอพัก
* Box.csv  ---> เก็บข้อมูลต่างๆของพัสดุที่เข้ามาส่งในหอพัก
* ReceiveBox.csv  ---> เก็บข้อมูลต่างๆของพัสดุที่รับเเล้ว
* ReceiveMail.csv  ---> เก็บข้อมูลต่างๆของจดหมายที่รับเเล้ว
* ReceiveText.csv  ---> เก็บข้อมูลต่างๆของเอกสารที่รับเเล้ว
* CentralOfficer.csv  ---> เก็บข้อมูลต่างๆของส่วนกลาง
* Customer.csv  ---> เก็บข้อมูลต่างๆของลูกบ้าน
* Room.csv  ---> เก็บข้อมูลจำนวนผู้เข้าพัก ชั้น เลขห้อง เเละ ขนาดห้องของหอพัก

> Controller
* เก็บ class ที่ควบคุมการทำงานของไฟล์ fxml

> Model
* เก็บ class ที่ควบคุม เก็บค่า คำนวนภายในโปรเจค

> Service
* เก็บ class ไว้สำหรับจัดการข้อมูลนอกโปรเจค

> resources
* เก็บไฟล์ fxml เเละ ข้อมูลที่ใช้ร่วมกับ scenebuilder

### การพัฒนาโปรเเกรมรายสัปดาห์

> **22.09.2020**

* [bd9166e](https://bitbucket.org/6210406572/6210406572/commits/bd9166ec18ce562f95de6db0aeb0af1c83a42eef)
                **add marven to project**
                -  เป็นการเพิ่ม marven เข้าโปรเจค

> **23.09.2020**

* [2a4ace4](https://bitbucket.org/6210406572/6210406572/commits/2a4ace4eff99697be0a3687b4e691c449bd71a11)
                **make profile page**
                **new add marven to project**
                **new make homepage page**
                        - ทำหน้าเพจ profile
                        - ทำ marven ใหม่เข้าไปในโปรเจค
                        - เเก้ไขหน้า homepage ใหม่ทั้งหมดพร้อมเชื่อมปุ่มหน้า homepage

> **30.09.2020**

* [cd8a77a](https://bitbucket.org/6210406572/6210406572/commits/cd8a77a7ddcfef7c44aee3654679a49ad744e319)
                **interface**
                        -เพิ่ม interface  set account ของ admi ในโปรเจค

> **07.10.2020**

* [cd8a77a](https://bitbucket.org/6210406572/6210406572/commits/cd8a77a7ddcfef7c44aee3654679a49ad744e319)
                **file**
                        - อ่าน file เขียน file csv

> **17.10.2020**

* [39f0de2](https://bitbucket.org/6210406572/6210406572/commits/39f0de2cc64ca4f769c655be6b140435bdc8d822)
                **make admin system**
                        - ทำระบบส่วนของ admin ทั้งหมด

> **21.10.2020**

* [4b5c398](https://bitbucket.org/6210406572/6210406572/commits/4b5c398601a659332b16a790ca44b2d314a257fc)
                **update admin system and centralhome**
                        -ทำเพิ่มเติมส่วนของ admin เเละทำหน้าส่วนกลางเพิ่มเติม

> **27.10.2020**
* [fb012ec](https://bitbucket.org/6210406572/6210406572/commits/fb012ec7961011fbcec5591c144e8ceff34acaef)
                **make stock page and receive page and list room**
                        -ทำส่วนหน้าตารางเเสดงการรับของ
                        -ทำส่วนหน้าตารางเเสดงของที่รับเเล้ว
                        -ทำส่วนหน้าเเสดงข้อมูลของห้องที่ถูกสร้างไว้เเล้ว
                        
> **29.10.2020**
* [c6d6fb5](https://bitbucket.org/6210406572/6210406572/commits/c6d6fb52d2c371a57ce0207eb69278f30503000c)
                **before make polymorphism**
                        -save ไฟล์งานก่อนทำ polymorphism
                        
> **29.10.2020**
* [4519148](https://bitbucket.org/6210406572/6210406572/commits/45191480747e4c2b02c185eeaab89435c0d82040)
                **finish polymorphish**
                        -ทำ polymorphish เสร็จ
                        
> **31.10.2020**
* [8d4e771](https://bitbucket.org/6210406572/6210406572/commits/8d4e7716433db0bdd05e6d4218f1810e4be40048)
                **finish project**
                        -ทำส่วน Customer service
                        -เสร็จการทำ Project
                      
> **27.11.2020**
* [c56e9cf](https://bitbucket.org/6210406572/6210406572/commits/c56e9cf169a82f7a427c085a76415239a3bc7a1d)
                **เเก้งานครั้งที่1**
                         -เเก้ไขหน้า Developer
                         -เเยก arraylist ในการทำงานของ class model
                         -เพิ่ม alert หน้าต่างๆ

> **27.11.2020**
* [9ec01d0](https://bitbucket.org/6210406572/6210406572/commits/9ec01d0fee704bbd8872fe2a5b670cfeed6513bf)
                **make new polymorphism*
                         -ทำ polymorphism ใหม่โดยการใช้ strategy pattern หลายส่วน