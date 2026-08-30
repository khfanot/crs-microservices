# BLUEPRINT API

## 1. Auth Service

**Cổng:** 8081  
**Tiền tố khi qua Gateway:** `/api/auth`

| Method | Endpoint | Mô tả | Yêu cầu |
|---|---|---|---|
| POST | /auth/login | Đăng nhập, trả về JWT | Public |
| POST | /auth/register | Đăng ký tài khoản | Public |

## 2. Course Service

**Cổng:** 8082  
**Tiền tố:** `/api/courses`

| Method | Endpoint | Mô tả | Yêu cầu |
|---|---|---|---|
| GET | /courses | Danh sách, có search + phân trang | Public |
| GET | /courses/{id} | Chi tiết một môn học | Public |
| POST | /courses | Thêm môn học | ADMIN |
| PUT | /courses/{id} | Sửa môn học | ADMIN |
| DELETE | /courses/{id} | Xóa môn học | ADMIN |

## 3. API nội bộ Course Service

API này chỉ gọi từ registration-service, không lộ ra Gateway cho Frontend.

| Method | Endpoint | Mô tả |
|---|---|---|
| PATCH | /internal/courses/{id}/reserve-seat | Kiểm tra còn chỗ, trừ số chỗ còn lại |
| PATCH | /internal/courses/{id}/release-seat | Hoàn trả một chỗ khi hủy đăng ký |

## 4. Registration Service

**Cổng:** 8083  
**Tiền tố:** `/api/registrations`

| Method | Endpoint | Mô tả | Yêu cầu |
|---|---|---|---|
| POST | /registrations | Đăng ký học phần, gọi sang course-service | STUDENT |
| GET | /registrations/my | Danh sách đăng ký của tôi | STUDENT |
| DELETE | /registrations/{id} | Hủy đăng ký, gọi release-seat | STUDENT/ADMIN |