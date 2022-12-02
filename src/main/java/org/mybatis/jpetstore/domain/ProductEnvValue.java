package org.mybatis.jpetstore.domain;

import java.io.Serializable;

public class ProductEnvValue implements Serializable {
    private static final long serialVersionUID = 6804536240066533087L;
    private String envValue;

    public String getEnvValue() {
        return envValue;
    }

    public void setEnvValue(String envValue) {
        this.envValue = envValue;
    }
}
