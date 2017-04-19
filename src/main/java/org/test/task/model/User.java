package org.test.task.model;

public class User {
    private long id;

    private String name;

    public User () {
        this.id = 0;
    }

    public User (String name) {
        this.id = 0;
        this.name = name;
    }

    public User (long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (this.id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Message [id=" + this.id + ", name=" + this.name + "]";
    }
}
