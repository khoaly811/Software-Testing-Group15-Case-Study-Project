#language: vi
Tính năng: Dời lịch họp
  Bối cảnh:
    Cho một người dùng di chuyển đến trang đăng nhập
    Và người dùng đó nhập email và mật khẩu

  Khung kịch bản: Dời lịch họp thành công
    Cho người dùng đang ở trang Quản lý nhóm và di chuyển đến phần Nhắn tin
    Cho người dùng chọn nhóm và di chuyển đến cuộc trò chuyện chung
    Khi người dùng chọn Lịch hẹn, người dùng bấm dấu cộng để thêm 1 cuộc hẹn
      | Tiêu đề | Mô tả | Thời gian bắt đầu | Thời gian kết thúc | Ngày | Địa điểm |
      |<Tiêu đề>|<Mô tả>|<Thời gian bắt đầu>|<Thời gian kết thúc>|<Ngày>|<Địa điểm>|
    Và người dùng bấm chọn Tạo lịch hẹn
    Thì màn hình sẽ xuất hiện thông báo rằng đã tạo lịch hẹn thành công
    Và cuộc họp sẽ được tạo với các thông tin sau
      | Tiêu đề | Mô tả | Thời gian bắt đầu | Thời gian kết thúc | Ngày | Địa điểm |
      |<Tiêu đề>|<Mô tả>|<Thời gian bắt đầu>|<Thời gian kết thúc>|<Ngày>|<Địa điểm>|

    Dữ liệu:
      | Tiêu đề    | Mô tả | Thời gian bắt đầu | Thời gian kết thúc | Ngày     | Địa điểm |
      |Họp Sprint 3|abc    |8:30 AM            |9:45 AM             |8/8/2024|HCMUS I41 |