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
      |K                |Group 15|   Tất cả     |
      |Nhóm automation 12Nhóm automation 2Nhóm automation 2Nhóm automation 2Nhóm automation 2Nhóm automation 2                |Group 15|   Tất cả     |
      |J                |Nhóm automation 2Nhóm automation 2Nhóm automation 2Nhóm automation 2Nhóm automation 2Nhóm automation 2|   Tất cả     |
      |Nhóm 12           |Group 15|   Tất cả     |
      |7                |G         |   Tất cả     |
      |Nhóm automation 12 |Group 15|Quyền gửi file|
      |Nhóm automation 13|Group 15 |Quyền gửi file, Quyền quản lí công việc |
      |Nhóm automation 14 |Group 15|Quyền gửi file|
      |Nhóm automation 15 |Group 15|Quyền quản lý câu hỏi thường gặp|
      |Nhóm automation 16 |Group 15|Quyền quản lý bản tin|
      |Nhóm automation 17 |Group 15|Quyền quản lý lịch hẹn|
      |Nhóm automation 18 |Group 15|Quyền cài đặt nhóm|
      |Nhóm automation 19 |Group 15|Quyền quản lý lịch hẹn, Quyền gửi file, Quyền quản lí công việ|
      |Nhóm automation 10 |Group 15|Quyền cài đặt nhóm, Quyền quản lý câu hỏi thường gặp|
    Thì màn hình sẽ xuất hiện thông báo rằng đã thêm loại nhóm thành công