#language: vi
@datatableEditAcc
Tính năng: Chỉnh sửa tài khoản
  Bối cảnh:
    Cho một người dùng di chuyển đến trang đăng nhập
    Và người dùng đó nhập email và mật khẩu


  Kịch bản: Chỉnh sửa tài khoản thành công
    Cho người dùng di chuyển đến trang Quản lý sửa tài khoản
    Và người dùng chọn tài khoản để chỉnh
    Khi tài khoản được chỉnh sửa với thông tin hợp lệ
      | Họ tên         | Email                       | Vai trò             | Số điên thoại  | Giới tính | Trạng thái|
      |Nhân Lê2        |lcnhan22@clc.fitus.edu.vn    |Quản trị viên cấp cao| 0900000000     | Nam       | Hoạt động |
      |PTrinh cte      |trinhntp22@clc.fitus.edu.vn  |Quản trị viên        | 0901805257     | Nữ        | Hoạt động |
      |Khoa Lúy        |Empty                        |Quản trị viên        | 0912345678     | MT        | Khóa      |
      |A               |a@g.c                        |Empty                | Empty          | Nữ        | Khóa      |
      |Blabla          |longname@gmail.com           |Người dùng           | 0912345678     | Nam       | MT        |
      |The sun set over|p@g.c                        |Người dùng           | 0900000000     | Nữ        | Khóa|
      |Khoa Lý Đăn     |b@g.c                        |Người dùng           | Empty          | MT        | Khóa      |
      |0905200         |Empty                        |Empty                | 0943018665     | Nam       | MT        |
      |090520045       |t@g.c                        |Người dùng           | 0912345678     | Nữ        | Khóa      |

    Thì màn hình sẽ xuất hiện thông báo rằng đã chỉnh sửa tài khoản thành công