#language: vi
@search
Tính năng: Tìm thông tin nhóm theo ngày bắt đầu và ngày kết thúc
  Bối cảnh:
    Cho một người dùng di chuyển đến trang đăng nhập
    Và người dùng đó nhập email và mật khẩu

  Kịch bản: Tìm kiếm nhóm thành công
    Cho người dùng đang ở trang Quản lý nhóm và bấm chọn thẻ Tìm kiếm
    Cho người dùng chọn tìm kiếm theo ngày bắt đầu và ngày kết thúc
    Khi một nhóm được tìm kiếm với các thông tin hợp lệ sau
      | Ngày bắt đầu từ | Ngày bắt đầu đến | Ngày kết thúc từ | Ngày kết thúc đến |
      |1/8/2024         |1/8/2024         |1/8/2024          |8/8/2024           |
      |1/7/2024         |29/7/2024         |1/8/2024          |8/8/2024           |
      |1/7/2024         |29/7/2024         |1/8/2024          |8/8/2024           |
    Thì người dùng thấy được các nhóm đã tìm kiếm