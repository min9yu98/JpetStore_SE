package org.mybatis.jpetstore.domain;

import java.io.Serializable;

public class ProductEnvItemList implements Serializable {
    private static final long serialVersionUID = 6804536240066533087L;
    private String envItem;

    public String getEnvItem() {
        return envItem;
    }

    public void setEnvItem(String envItem) {
        this.envItem = envItem;
    }
}
