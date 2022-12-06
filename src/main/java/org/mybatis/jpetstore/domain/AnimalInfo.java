package org.mybatis.jpetstore.domain;

/*
 *    Copyright 2010-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The Class Item.
 *
 * @author Eduardo Macarron
 */
public class AnimalInfo implements Serializable {

    private static final long serialVersionUID = -2159121673445254632L;

    private String columname;
    private int columnId;
    private String value;
    private String categoryId;
    private String productId;
    private int animalinfovalueId;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public int getAnimalinfovalueId() {
        return animalinfovalueId;
    }

    public void setAnimalinfovalueId(int animalinfovalueId) {
        this.animalinfovalueId = animalinfovalueId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getColumname() {
        return columname;
    }

    public void setColumname(String columname) {
        this.columname = columname;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
