package Lab7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {
    List<User> userlist = new ArrayList();

    public Register() {
    }

    public List<User> loading() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");

            try {
                Statement stmt = conn.createStatement();

                try {
                    String select = "Select * from users";
                    ResultSet rset = stmt.executeQuery(select);

                    while(rset.next()) {
                        User obj = new User();
                        obj.setId(rset.getInt("id"));
                        obj.setUsername(rset.getString("name"));
                        obj.setPassword(rset.getString("password"));
                        obj.setRole(rset.getInt("role"));
                        obj.setCreate(rset.getString("createddate"));
                        obj.setUpdate(rset.getString("updateddate"));
                        this.userlist.add(obj);
                    }
                } catch (Throwable var8) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var9) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }

        return this.userlist;
    }

    public boolean signUp(User user) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");

            boolean var5;
            try {
                Statement stmt = conn.createStatement();

                try {
                    String var10000 = user.getUsername();
                    String signup = "insert into users(name,password,role,createddate) values('" + var10000 + "','" + user.getPassword() + "'," + user.getRole() + ",'" + user.getCreate() + "',curdate())";
                    stmt.executeUpdate(signup);
                    this.loading();
                    System.out.println("Signup successfully");
                    var5 = true;
                } catch (Throwable var8) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var9) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (conn != null) {
                conn.close();
            }

            return var5;
        } catch (SQLException var10) {
            var10.printStackTrace();
            return false;
        }
    }

    public User signIn() {
        User obj = new User();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");

            try {
                Statement stmt = conn.createStatement();

                try {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Enter your username: ");
                    String name = input.nextLine();
                    System.out.println("Enter your password: ");
                    String pass = input.nextLine();
                    String select = "Select * from users where name ='" + name + "' AND password ='" + pass + "'";

                    int id;
                    String username;
                    String password;
                    int role;
                    String create;
                    String update;
                    for(ResultSet rset = stmt.executeQuery(select); rset.next(); obj = new User(id, username, password, role, create, update)) {
                        id = rset.getInt("id");
                        username = rset.getString("name");
                        password = rset.getString("password");
                        role = rset.getInt("role");
                        create = rset.getString("createddate");
                        update = rset.getString("updateddate");
                    }

                    System.out.println("Sign in successfully");
                } catch (Throwable var17) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var16) {
                            var17.addSuppressed(var16);
                        }
                    }

                    throw var17;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var18) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var15) {
                        var18.addSuppressed(var15);
                    }
                }

                throw var18;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var19) {
            var19.printStackTrace();
        }

        return obj;
    }

    public void displayUser() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");

            try {
                Statement stmt = conn.createStatement();

                try {
                    String stt = "Select * from users";
                    ResultSet rset = stmt.executeQuery(stt);
                    ResultSetMetaData rsetMD = rset.getMetaData();
                    int numColums = rsetMD.getColumnCount();

                    int i;
                    for(i = 1; i <= numColums; ++i) {
                        System.out.printf("%-30s", rsetMD.getColumnName(i));
                    }

                    this.loading();

                    for(i = 0; i < this.userlist.size(); ++i) {
                        System.out.println(((User)this.userlist.get(i)).toString());
                    }
                } catch (Throwable var10) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var9) {
                            var10.addSuppressed(var9);
                        }
                    }

                    throw var10;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var11) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var8) {
                        var11.addSuppressed(var8);
                    }
                }

                throw var11;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var12) {
            var12.printStackTrace();
        }

    }
}
