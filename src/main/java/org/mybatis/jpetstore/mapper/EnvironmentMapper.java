package org.mybatis.jpetstore.mapper;

import org.apache.ibatis.annotations.Param;
import org.mybatis.jpetstore.domain.EnvironmentByUser;

import java.util.List;

public interface EnvironmentMapper {
    List<EnvironmentByUser> getUserEnvList(@Param("categoryId") String categoryId, @Param("username") String username);
}
