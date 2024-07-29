#language: vi
@datatable
Tính năng: Dời lịch họp
  Bối cảnh:
    Cho một người dùng di chuyển đến trang đăng nhập
    Và người dùng đó nhập email và mật khẩu
    Cho người dùng đang ở trang Quản lý nhóm và di chuyển đến phần Nhắn tin
    Cho người dùng chọn nhóm và di chuyển đến cuộc trò chuyện chung

  Kịch bản: Tạo cuộc họp thành công
    Cho người dùng chọn Lịch hẹn
    Khi một cuộc hẹn đã được tạo với các thông tin hợp lệ
      | Tiêu đề    | Mô tả | Thời gian bắt đầu | Thời gian kết thúc | Ngày     | Địa điểm |
      |Sprint 1    |abc    |8:30 AM            |9:45 AM             |8/8/2024  |HCMUS I41 |
      |Sprint 2    |abc    |8:30 AM            |9:45 AM             |8/8/2024  |HCMUS I41 |
      |Sprint 3    |abc    |8:30 AM            |9:45 AM             |8/8/2024  |HCMUS I41 |
    Thì màn hình sẽ xuất hiện thông báo rằng đã tạo lịch hẹn thành công

  Kịch bản: Tạo cuộc họp thất bại
    Cho người dùng chọn Lịch hẹn
    Khi một cuộc hẹn được tạo nhưng vượt quá 255 kí tự ở 1 trong 3 trường Tiêu đề, Mô tả, Địa điểm
      | Tiêu đề    | Mô tả | Thời gian bắt đầu | Thời gian kết thúc | Ngày     | Địa điểm |
      |P3izBhH1VXxBUByFDVFZ5JKTWmnBU0F7IKKeq99TrE0lyEVoGgYRgcfMpCbFwbQ6jkFHXQ4QyhiO8J0Z5nNFw8GKVr7epODEv7i2AR5k6GQA8NuKbuYfXopfxM4t4AOwSDAQh6ckhW4iLdoVnUdPRphgb6aruDv7vP8cJxfFR6uE9ZWD5xE53zzdeGcG3chVPCxk6dKG5gnjE2FJYpyRpRAJYA6xpCy7s05UbqyuICPis9UeHFGDoQ8xt2JZ9ZKv    |abc    |8:30 AM            |9:45 AM             |8/8/2024  |HCMUS I41 |
      |Sprint 2    |P3izBhH1VXxBUByFDVFZ5JKTWmnBU0F7IKKeq99TrE0lyEVoGgYRgcfMpCbFwbQ6jkFHXQ4QyhiO8J0Z5nNFw8GKVr7epODEv7i2AR5k6GQA8NuKbuYfXopfxM4t4AOwSDAQh6ckhW4iLdoVnUdPRphgb6aruDv7vP8cJxfFR6uE9ZWD5xE53zzdeGcG3chVPCxk6dKG5gnjE2FJYpyRpRAJYA6xpCy7s05UbqyuICPis9UeHFGDoQ8xt2JZ9ZKv    |8:30 AM            |9:45 AM             |8/8/2024  |HCMUS I41 |
      |Sprint 3    |abc    |8:30 AM            |9:45 AM             |8/8/2024  |P3izBhH1VXxBUByFDVFZ5JKTWmnBU0F7IKKeq99TrE0lyEVoGgYRgcfMpCbFwbQ6jkFHXQ4QyhiO8J0Z5nNFw8GKVr7epODEv7i2AR5k6GQA8NuKbuYfXopfxM4t4AOwSDAQh6ckhW4iLdoVnUdPRphgb6aruDv7vP8cJxfFR6uE9ZWD5xE53zzdeGcG3chVPCxk6dKG5gnjE2FJYpyRpRAJYA6xpCy7s05UbqyuICPis9UeHFGDoQ8xt2JZ9ZKv |
    Thì màn hình sẽ xuất hiện thông báo rằng đã tạo lịch hẹn thất bại

#  Kịch bản: Không tạo được cuộc họp do để trống trường thông tin
#    Cho người dùng chọn Lịch hẹn
#    Khi một cuộc hẹn được tạo với các trường Tiêu đề hoặc Người tham dự để trống
#    Thì form tạo cuộc hẹn sẽ xuất hiện các thông báo lỗi tại trường thông tin để trống
