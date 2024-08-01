#language: vi
@create_category
Tính năng: Tạo 1 loại nhóm
  Bối cảnh:
    Cho một người dùng di chuyển đến trang đăng nhập
    Và người dùng đó nhập email và mật khẩu

  Kịch bản: Dời lịch hẹn thành công
    Cho người dùng đang ở trang Quản lý nhóm và đi đến trang Quản lý loại nhóm
    Cho người dùng bấm chọn Thêm mới 1 loại nhóm
    Khi một loại nhóm được thêm với thông tin hợp lệ
      | Tên loại nhóm   | Mô tả  |Quyền ứng dụng|
      |Nhóm automation 1|Group 15|   Tất cả     |
      |Nhóm automation 2|Group 15|Quyền gửi file|
      |Nhóm automation 3|Group 15|Quyền gửi file, Quyền quản lí công việc |
    Thì màn hình sẽ xuất hiện thông báo rằng đã thêm loại nhóm thành công