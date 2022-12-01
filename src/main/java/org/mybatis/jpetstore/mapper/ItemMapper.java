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
package org.mybatis.jpetstore.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.jpetstore.domain.AnimalInfo;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;

/**
 * The Interface ItemMapper.
 *
 * @author Eduardo Macarron
 */
public interface ItemMapper {
  void deleteItem(String itemId);

  void updateInventoryQuantity(Map<String, Object> param);

  int getInventoryQuantity(String itemId);

  List<Item> getItemListByProduct(String productId);

  Item getItem(String itemId);

  List<Item> getAllItemList();

  // Admin 쿼리
  void insertItemByAdmin(Item item);

  void insertInventoryByAdmin(Item item);

  void updateItemByAdmin(Item item);

  void updateInventoryByAdmin(Item item);

  void deleteItemByAdmin(String itemId);
  
  List<AnimalInfo> getAnimalInfo(@Param("categoryId") String categoryId, @Param("productId") String productId);

  void updateAnimalInfoValueByAdmin(AnimalInfo animalInfo);

  int getAnimalInfoValueId(@Param("categoryId") String categoryId, @Param("productId") String productId, @Param("columname") String columname);

  void insertAnimalInfoByAdmin(AnimalInfo animalInfo);

  void deleteAnimalInfoByAdmin(@Param("categoryId") String categoryId, @Param("columnId") int columnId);

  int getAnimalInfoColumnId(String columname);
}
