package org.mybatis.jpetstore.domain;

import java.io.Serializable;

public class AnimalInfoColumn implements Serializable {
    private static final long serialVersionUID = -2159121923445254632L;
    private String columname;
    public String getColumname() {
        return columname;
    }

    public void setColumname(String columname) {
        this.columname = columname;
    }
}
