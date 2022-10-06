package com.company;

import java.util.List;

public class PersonWithBankAccounts {
    private String name;
    List<String> ibans;

    public PersonWithBankAccounts(String name, List<String> ibans) {
        this.name = name;
        this.ibans = ibans;
    }



    public String getName() {
        return name;
    }

    public List<String> getIbans() {
        return ibans;
    }

    @Override
    public String toString() {
        return "PersonWithBankAccounts: " +
                 name +  ibans ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonWithBankAccounts)) return false;

        PersonWithBankAccounts that = (PersonWithBankAccounts) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return ibans != null ? ibans.equals(that.ibans) : that.ibans == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (ibans != null ? ibans.hashCode() : 0);
        return result;
    }
}
