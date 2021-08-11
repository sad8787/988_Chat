package User;

import java.net.Socket;

public class User {
    String name;
    public Socket soket;

    public User( Socket soket) {
        this.soket = soket;
    }

    public String getName() {
        return name;
    }

    public Socket getSoket() {
        return soket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoket(Socket soket) {
        this.soket = soket;
    }
}
