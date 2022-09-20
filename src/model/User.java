package model;

public class User {

    //定义private变量，与数据库中一致
    private int id;//定义用户id
    private String username;//定义用户名
    private String email;//定义用户email
    private String password;//定义用户password
    private String name;//定义用户昵称
    private String phone;//定义用户联系电话
    private String address;//定义用户收货地址
    private boolean isadmin=false;//判断是否为管理员
    private boolean isvalidate=false;//判断账户是否有效


    //id方法
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    //username方法
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    //email方法
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    //password方法
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", name="
                + name + ", phone=" + phone + ", address=" + address + ", isadmin=" + isadmin + ", isvalidate="
                + isvalidate + "]";
    }

    //name方法
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    //phone方法
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    //address方法
    public String getAddress(){
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    //isadmin方法
    public boolean isIsadmin() {
        return isadmin;
    }
    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }
    //isvalidate方法
    public boolean isIsvalidate() {
        return isvalidate;
    }
    public void setIsvalidate(boolean isvalidate) {
        this.isvalidate = isvalidate;
    }

    //构造
    public User(int id,String username,String email,String password,String name,
                String phone,String address,boolean isadmin,boolean isvalidate){
        super();
        this.id=id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.isadmin = isadmin;
        this.isvalidate = isvalidate;
    }
    public User( String username, String email, String password, String name, String phone, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.isadmin = false;
        this.isvalidate = false;
    }
    public User() {
        super();
    }
}
