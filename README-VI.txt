OreBloom — Minecraft Java 1.21.11 / Fabric
==========================================

Tình trạng gói
--------------
Đây là PROJECT MÃ NGUỒN để build thành mod .jar, không phải file .jar đã biên dịch.
Môi trường tạo tệp hiện tại không có kết nối tới Maven/Gradle repositories nên không
thể tải thư viện Minecraft/Fabric và xác nhận build thực tế. Không cài file ZIP này
trực tiếp vào thư mục mods.

Chức năng được cấu hình
-----------------------
- Thêm 20 loại feature vào tất cả biome Overworld thông qua Fabric Biome API.
- Quặng Overworld: coal, iron, copper, gold, redstone, lapis, diamond, emerald.
- Quặng Nether xuất hiện ở Overworld: nether quartz, nether gold, ancient debris.
- Khối tài nguyên: coal, iron, gold, netherite, diamond, emerald, lapis,
  raw iron, raw gold.
- Mỗi feature có 20 lần thử mỗi chunk; chiều cao đồng đều từ Y=-64 đến Y=319.
- Kích thước cụm được đặt riêng; khối nguyên khối có cụm nhỏ hơn quặng.

Cảnh báo hiệu năng
------------------
20 feature × 20 lần thử = tối đa khoảng 400 lần thử đặt feature mỗi chunk trước
khi tính việc một số lần thử không đặt được block. Tạo chunk có thể chậm hơn rất
nhiều so với vanilla. Không phải 256 lần so với từng loại quặng vanilla; cấu hình
này diễn giải yêu cầu mới nhất là mọi loại đều có tần suất thử tương đương nhau
(20 lần/chunk), kiểu độ dày gần Coal.

Cách build thành .jar
---------------------
Yêu cầu:
- JDK 21
- Gradle cài sẵn
- Kết nối Internet để Gradle tải Minecraft, Fabric Loader và Fabric API.

Tại thư mục dự án, chạy:
    gradle build

File đầu ra dự kiến:
    build/libs/orebloom-1.0.0.jar

Cài đặt:
1. Đảm bảo profile game là Minecraft Java 1.21.11 + Fabric Loader.
2. Cài Fabric API bản 0.141.1+1.21.11 (hoặc bản tương thích mới hơn).
3. Chép file orebloom-1.0.0.jar vào .minecraft/mods (hoặc thư mục mods của launcher).
4. Tạo thế giới mới để kiểm tra. Mod chỉ tác động quá trình sinh chunk mới;
   chunk đã được tạo trước đó không tự sinh lại quặng.
5. Sao lưu thế giới trước khi thử vì mật độ rất cao.

Lưu ý:
- Nếu chơi trên Zalith/Android, cần đặt file JAR đã build vào thư mục mods của
  đúng profile Fabric, không đặt ZIP mã nguồn này vào mods.
- Build project cần Gradle và tải dependency lần đầu; chỉ có JDK thôi là chưa đủ.
