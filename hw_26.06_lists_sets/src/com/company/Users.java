package com.company;

public class Users implements Comparable<Users>{
    private String name;
    private String email;

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int compareTo(Users o){
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;

        Users users = (Users) o;

        if (name != null ? !name.equals(users.name) : users.name != null) return false;
        return email != null ? email.equals(users.email) : users.email == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
