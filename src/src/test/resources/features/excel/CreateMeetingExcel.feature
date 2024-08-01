#language: vi
@excel
Tính năng: Tạo cuộc họp
  Bối cảnh:
    Cho một người dùng di chuyển đến trang đăng nhập
    Và người dùng đó nhập email và mật khẩu
    Cho người dùng đang ở trang Quản lý nhóm và di chuyển đến phần Nhắn tin
    Cho người dùng chọn và chuyển đến cuộc trò chuyện chung

  Kịch bản: Tạo cuộc họp thành công
    Cho người dùng chọn Cuộc hẹn trên màn hình
    Khi một cuộc hẹn đã được tạo với các thông tin hợp lệ từ file excel: "src/test/resources/input_cuocHop_test.xlsx"
    Thì màn hình sẽ xuất hiện thông báo đã tạo lịch hẹn thành công


