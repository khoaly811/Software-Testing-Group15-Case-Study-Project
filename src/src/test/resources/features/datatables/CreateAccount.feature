#language: vi
@datatableCreateAcc
Tính năng: Tạo tài khoản
  Bối cảnh:
    Cho một người dùng di chuyển đến trang đăng nhập
    Và người dùng đó nhập email và mật khẩu


  Kịch bản: Tạo tài khoản thành công
    Cho người dùng di chuyển đến trang Quản lý thêm tài khoản
    Và người dùng chọn Thêm tài khoản
    Khi tài khoản được thêm với thông tin hợp lệ
      | Họ tên         | Email                       | Vai trò             |
      |Nhân Lê         |lcnhan22@clc.fitus.edu.vn    |Quản trị viên cấp cao|
      |A               |a@g.c                        |Người dùng           |
      |The sun set over the horizon, casting a golden hue across the landscape. Birds chirped melodiously, returning to their nests. Children played in the park, laughter echoing through the air. As the day ended, a sense of peace enveloped the town, promisings               |longname@gmail.com           |Người dùng           |
      |The sun set over the horizon, casting a golden hue across the landscape. Birds chirped melodiously, returning to their nests. Children played in the park, laughter echoing through the air. As the day ended, a sense of peace enveloped the town, promisings               |p@g.c                        |Người dùng           |
      |Khoa Lý Đăng    |b@g.c                        |Người dùng           |


    Thì màn hình sẽ xuất hiện thông báo rằng đã tạo tài khoản thành công

  Kịch bản: Tạo tài khoản với email không hợp lệ
    Cho người dùng di chuyển đến trang Quản lý thêm tài khoản
    Và người dùng chọn Thêm tài khoản
    Khi tài khoản được thêm với email không hợp lệ
      | Họ tên         | Email                       | Vai trò              |
      |Nhân Lê         |@blavla                      |Quản trị viên cấp cao|
      |A               |nhanle@@blablabla             |Người dùng            |
      |Phương Trinh    |@gmail.com                   |Người dùng            |

    Thì màn hình sẽ xuất hiện thông báo rằng email không hợp lệ

  Kịch bản: Tạo tài khoản thếu trường thông tin Họ tên
    Cho người dùng di chuyển đến trang Quản lý thêm tài khoản
    Và người dùng chọn Thêm tài khoản
    Khi tài khoản được thêm với thông tin không hợp lệ thiếu tên
      | Email                       | Vai trò             |
      |lcnhan22@clc.fitus.edu.vn    |Quản trị viên cấp cao|
#      |longname@gmail.com           |Người dùng           |
#      |p@g.c                        |Quản trị viên        |

    Thì màn hình sẽ xuất hiện thông báo rằng có trường họ tên bị thiếu

  Kịch bản: Tạo tài khoản thếu trường thông tin Email
    Cho người dùng di chuyển đến trang Quản lý thêm tài khoản
    Và người dùng chọn Thêm tài khoản
    Khi tài khoản được thêm với thông tin không hợp lệ thiếu Email
      | Họ tên                      | Vai trò             |
      |Nhân Lê                      |Quản trị viên cấp cao|
#      |a                            |Người dùng           |
#      |The sun set over the horizon, casting a golden hue across the landscape. Birds chirped melodiously, returning to their nests. Children played in the park, laughter echoing through the air. As the day ended, a sense of peace enveloped the town, promisings                        |Quản trị viên        |

    Thì màn hình sẽ xuất hiện thông báo rằng có trường email bị thiếu

  Kịch bản: Tạo tài khoản thếu trường thông tin Vai trò
    Cho người dùng di chuyển đến trang Quản lý thêm tài khoản
    Và người dùng chọn Thêm tài khoản
    Khi tài khoản được thêm với thông tin không hợp lệ thiếu Vai trò
      | Họ tên         | Email                       |
      |Nhân Lê         |lcnhan23@clc.fitus.edu.vn    |
#      |A               |a@g.c                        |
#      |The sun set over the horizon, casting a golden hue across the landscape. Birds chirped melodiously, returning to their nests. Children played in the park, laughter echoing through the air. As the day ended, a sense of peace enveloped the town, promisings               |longname@gmail.com           |
#      |The sun set over the horizon, casting a golden hue across the landscape. Birds chirped melodiously, returning to their nests. Children played in the park, laughter echoing through the air. As the day ended, a sense of peace enveloped the town, promisings               |p@g.c                        |
#      |Khoa Lý Đăng    |b@g.c                        |


    Thì màn hình sẽ xuất hiện thông báo rằng có trường vai trò bị thiếu