package rj.bookstore.admin.entity;

public class Admin {
    private String auid;
    private String adminname;
    private String password;

    public Admin(){}

    public Admin(String auid, String adminname, String password) {
        this.auid = auid;
        this.adminname = adminname;
        this.password = password;
    }

    public String getAuid() {
        return auid;
    }

    public void setAuid(String auid) {
        this.auid = auid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
