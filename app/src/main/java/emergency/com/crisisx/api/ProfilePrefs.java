package emergency.com.crisisx.api;

import android.content.Context;
import android.content.SharedPreferences;

public class ProfilePrefs {

    private boolean reg;
    private String name, phone, email, id, pwd, addr;
    SharedPreferences preferences;
    SharedPreferences.Editor prefEditor;
    Context context;

    public ProfilePrefs(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences("PROFILE", context.MODE_PRIVATE);
        prefEditor = preferences.edit();
    }

    public void setPref(String name, String phone, String email, String addr) {
        prefEditor.putString("NAME", name);
        prefEditor.putString("PHONE", phone);
        prefEditor.putString("EMAIL", email);
        prefEditor.putString("ADDR", addr);
        prefEditor.commit();
    }

    public boolean getReg() {
        this.reg = preferences.getBoolean("REGISTER", reg);
        return reg;
    }

    public void setReg(boolean reg) {
        this.reg = reg;
        prefEditor.putBoolean("REGISTER", reg);
        prefEditor.commit();
    }

    public String getId() {
        this.id = preferences.getString("ID", id);
        return id;
    }

    public void setId(String id) {
        prefEditor.putString("ID", id);
        prefEditor.commit();
        this.id = id;
    }

    public String getPwd() {
        this.id = preferences.getString("PWD", pwd);
        return id;
    }

    public void setPwd(String pwd) {
        prefEditor.putString("PWD", pwd);
        prefEditor.commit();
        this.pwd = pwd;
    }

    public String getName() {
        this.name = preferences.getString("NAME", null);
        return name;
    }

    public String getPhone() {
        this.phone = preferences.getString("PHONE", null);
        return phone;
    }

    public String getEmail() {
        this.email = preferences.getString("EMAIL", null);
        return email;
    }

    public String getAddr() {
        this.addr = preferences.getString("ADDR", null);
        return addr;
    }
}
