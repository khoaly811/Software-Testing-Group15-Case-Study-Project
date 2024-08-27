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
      |A               |a@g.c                        |Người dùng           | Empty          | Nữ        | Khóa      |
      |The sun set over|p@g.c                        |Người dùng           | 0900000000     | Nữ        | Hoạt động |
      |090520045       |t@g.c                        |Người dùng           | 0912345678     | Nữ        | Khóa      |

    Thì màn hình sẽ xuất hiện thông báo rằng đã chỉnh sửa tài khoản thành công

  Kịch bản: Chỉnh sửa tài khoản không thành công
    Cho người dùng di chuyển đến trang Quản lý sửa tài khoản
    Và người dùng chọn tài khoản để chỉnh
    Khi tài khoản được chỉnh sửa với thông tin không hợp lệ thiếu họ tên
      | Email                       | Vai trò             | Số điên thoại  | Giới tính | Trạng thái|
      |lcnhan22@clc.fitus.edu.vn    |Quản trị viên cấp cao| 0900000000     | Nam       | Hoạt động |
#      |trinhntp22@clc.fitus.edu.vn  |Quản trị viên        | 0901805257     | Nữ        | Hoạt động |
#      |a@g.c                        |Người dùng           | Empty          | Nữ        | Khóa      |
#      |p@g.c                        |Người dùng           | 0900000000     | Nữ        | Hoạt động |
#      |t@g.c                        |Người dùng           | 0912345678     | Nữ        | Khóa      |

    Thì màn hình sẽ xuất hiện thông báo rằng đã thiếu họ tên

  Kịch bản: Chỉnh sửa tài khoản không thành công email sai
    Cho người dùng di chuyển đến trang Quản lý sửa tài khoản
    Và người dùng chọn tài khoản để chỉnh
    Khi tài khoản được chỉnh sửa với thông tin không hợp lệ email
      | Họ tên         | Email                       | Vai trò             | Số điên thoại  | Giới tính | Trạng thái|
      |Nhân Lê2        |@clc.fitus.edu.vn            |Quản trị viên cấp cao| 0900000000     | Nam       | Hoạt động |
#      |PTrinh cte      |2clc.fitus.edu               |Quản trị viên        | 0901805257     | Nữ        | Hoạt động |
#      |A               |0905pt@                      |Người dùng           | Empty          | Nữ        | Khóa      |


    Thì màn hình sẽ xuất hiện thông báo rằng email thêm không hợp lệ

  Kịch bản: Chỉnh sửa tài khoản không thành công vai trò
    Cho người dùng di chuyển đến trang Quản lý sửa tài khoản
    Và người dùng chọn tài khoản để chỉnh
    Khi tài khoản được chỉnh sửa với thông tin không hợp lệ thiếu vai trò
      | Họ tên         | Email                       | Số điên thoại  | Giới tính | Trạng thái|
      |Nhân Lê2        |lcnhan22@clc.fitus.edu.vn    | 0900000000     | Nam       | Hoạt động |
#      |PTrinh cte      |trinhntp22@clc.fitus.edu.vn  | 0901805257     | Nữ        | Hoạt động |
#      |A               |a@g.c                        | Empty          | Nữ        | Khóa      |
#      |The sun set over|p@g.c                        | 0900000000     | Nữ        | Hoạt động |
#      |090520045       |t@g.c                        | 0912345678     | Nữ        | Khóa      |

    Thì màn hình sẽ xuất hiện thông báo rằng đã chỉnh sửa tài khoản không thành công thiếu vai trò