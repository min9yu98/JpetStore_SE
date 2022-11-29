package org.mybatis.jpetstore.domain;

import java.io.Serializable;

public class EnvironmentByUser implements Serializable  {
    private static final long serialVersionUID = 6804536240033522887L;
    private String envColumnName;
    private String envItem;

    public String getEnvColumnName() {
        return envColumnName;
    }

    public void setEnvColumnName(String envColumnName) {
        this.envColumnName = envColumnName;
    }

    public String getEnvItem() {
        return envItem;
    }

    public void setEnvItem(String envItem) {
        this.envItem = envItem;
    }
}
