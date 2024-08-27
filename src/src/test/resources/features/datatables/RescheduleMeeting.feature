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
      |8:59 AM            |9:43 PM             |17/8/2024  |
      |5:30 AM            |11:45 PM             |31/8/2024  |
      |1:30 AM            |9:55 AM             |30/9/2024  |
      |6:30 AM            |11:45 AM             |31/10/2024  |
      |1:33 AM            |11:59 PM             |30/11/2024  |
      |6:30 AM            |9:45 PM             |31/12/2024  |
      |6:30 AM            |10:45 AM             |1/12/2024  |
    Thì màn hình sẽ xuất hiện thông báo rằng đã lưu lịch hẹn thành công

