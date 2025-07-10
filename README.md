# HuynhGia Farm Management System - Backend

Hệ thống quản lý nông trại HuynhGia - Backend API

## 🚀 Công nghệ sử dụng

### Core Framework
- **Spring Boot 3.2.6** - Framework chính cho backend
- **Java 17** - Ngôn ngữ lập trình
- **Gradle** - Build tool

### Database & ORM
- **MySQL** - Hệ quản trị cơ sở dữ liệu
- **Spring Data JPA** - ORM framework
- **Hibernate** - JPA implementation

### API Documentation
- **SpringDoc OpenAPI** - Tự động tạo API documentation
- **Swagger UI** - Giao diện xem và test API

### Development Tools
- **Lombok** - Giảm boilerplate code
- **Spring Boot DevTools** - Hot reload trong development

### AI Development Assistant
- **Claude Sonnet 4** - AI coding assistant hỗ trợ phát triển
- **Cursor IDE** - AI-powered code editor với autocomplete và code generation

## 📋 Yêu cầu hệ thống

- **Java 17** hoặc cao hơn
- **MySQL 8.0** hoặc cao hơn
- **Gradle 7.0** hoặc cao hơn (hoặc sử dụng Gradle Wrapper)

## 🛠️ Cài đặt và chạy ứng dụng

### Bước 1: Clone project
```bash
git clone <repository-url>
cd huynhgia-be
```

### Bước 2: Cài đặt Java 17
Đảm bảo bạn đã cài đặt Java 17 trên máy:

**Windows:**
- Tải và cài đặt OpenJDK 17 từ: https://adoptium.net/
- Thêm JAVA_HOME vào Environment Variables

**macOS:**
```bash
brew install openjdk@17
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

### Bước 3: Cài đặt MySQL
**Windows:**
- Tải MySQL Community Server từ: https://dev.mysql.com/downloads/mysql/
- Cài đặt và thiết lập root password

**macOS:**
```bash
brew install mysql
brew services start mysql
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt update
sudo apt install mysql-server
sudo systemctl start mysql
sudo systemctl enable mysql
```

### Bước 4: Tạo database
```sql
CREATE DATABASE huynhgiafarm CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### Bước 5: Cấu hình database
Chỉnh sửa file `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/huynhgiafarm?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=your_username
spring.datasource.password=your_password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Swagger Configuration
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
```

**Lưu ý:** Thay `your_username` và `your_password` bằng thông tin đăng nhập MySQL của bạn.

### Bước 6: Chạy ứng dụng

**Sử dụng Gradle Wrapper (khuyến nghị):**
```bash
# Windows
./gradlew.bat bootRun

# macOS/Linux
./gradlew bootRun
```

**Hoặc build và chạy:**
```bash
# Build project
./gradlew build

# Chạy JAR file
java -jar build/libs/huynhgia-be-0.0.1-SNAPSHOT.jar
```

### Bước 7: Kiểm tra ứng dụng
- **API Documentation:** http://localhost:8080/swagger-ui.html
- **Health Check:** http://localhost:8080/actuator/health (nếu có)

## 📊 Cấu trúc Database

### Bảng ImportPrice
```sql
CREATE TABLE ImportPrice (
    Id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Type VARCHAR(100) NOT NULL,
    Name VARCHAR(200) NOT NULL,
    ImportPrice DECIMAL(10, 2) NOT NULL,
    UnitOfMeasure VARCHAR(50),
    Note TEXT,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## 🔧 Cấu hình nâng cao

### Development Profile
Tạo file `src/main/resources/application-dev.properties`:
```properties
# Development specific settings
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

### Production Profile
Tạo file `src/main/resources/application-prod.properties`:
```properties
# Production specific settings
spring.jpa.show-sql=false
logging.level.root=WARN
```

### Chạy với profile cụ thể
```bash
./gradlew bootRun --args='--spring.profiles.active=dev'
```

## 📚 API Endpoints

### ImportPrice APIs
- `GET /api/import-prices` - Lấy danh sách tất cả import prices
- `POST /api/import-prices` - Tạo mới import price
- `GET /api/import-prices/{id}` - Lấy import price theo ID
- `PUT /api/import-prices/{id}` - Cập nhật import price
- `DELETE /api/import-prices/{id}` - Xóa import price

### Các API khác
- Supplier APIs: `/api/suppliers`
- Shopper APIs: `/api/shoppers`
- Import APIs: `/api/imports`
- Export APIs: `/api/exports`

## 🐛 Troubleshooting

### Lỗi kết nối database
1. Kiểm tra MySQL service đang chạy
2. Kiểm tra thông tin kết nối trong `application.properties`
3. Đảm bảo database `huynhgiafarm` đã được tạo

### Lỗi port 8080 đã được sử dụng
Thêm vào `application.properties`:
```properties
server.port=8081
```

### Lỗi Java version
Đảm bảo sử dụng Java 17:
```bash
java -version
```

## 📝 Ghi chú

- Ứng dụng sử dụng Hibernate với `ddl-auto=update`, tự động tạo/cập nhật schema
- Swagger UI có sẵn tại `/swagger-ui.html` để test API
- Tất cả API trả về JSON format
- Timestamp được tự động tạo khi insert record mới

## 🤝 Đóng góp

1. Fork project
2. Tạo feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Tạo Pull Request

## 📄 License

Project này được phát triển cho HuynhGia Farm Management System. 