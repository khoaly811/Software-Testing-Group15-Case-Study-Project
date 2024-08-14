#language: vi
@reschedule
Tính năng: Dời một lịch hẹn
  Bối cảnh:
    Cho một người dùng di chuyển đến trang đăng nhập
    Và người dùng đó nhập email và mật khẩu

  Kịch bản: Dời lịch hẹn thành công
    Cho người dùng đang ở trang Quản lý nhóm và đi đến phần Nhắn tin
    Cho người dùng chọn nhóm và đi đến cuộc trò chuyện chung
    Cho người dùng bấm chọn Mở lịch để dời lịch lẹn
    Khi một cuộc hẹn được dời với các thông tin hợp lệ
      | Thời gian bắt đầu | Thời gian kết thúc | Ngày     |
      |8:30 AM            |9:45 AM             |14/8/2024  |
      |8:30 AM            |11:45 AM             |31/12/2024  |
      |6:30 AM            |9:45 AM             |31/8/2024  |
    Thì màn hình sẽ xuất hiện thông báo rằng đã lưu lịch hẹn thành công

