package com.zhy.mapper;

import com.zhy.model.outsourcing.OutsourcingUserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zhangocean
 * @Date: Created in 18:48 2018/3/24
 * Describe: 外包人员信息的sql语句
 */
@Mapper
@Repository
public interface OutsourcingUserInfoMapper {

    @Insert("insert into outsourcinguserinfo values(#{name},#{gender},#{managerPhone},#{phone},#{project},#{promise},#{contract})")
    void saveUserInfo(OutsourcingUserInfo outsourcingUserInfo);

    @Select("select * from outsourcinguserinfo where mangerphone=#{mangerPhone}")
    List<OutsourcingUserInfo> selectAllOutsourcingUserInfoByMangerPhone(@Param("mangerPhone") String mangerPhone);

    @Select("select * from outsourcinguserinfo where phone=#{phone} and project=#{project}")
    OutsourcingUserInfo getUserInfoByPhoneAndProjectName(@Param("phone") String phone, @Param("project") String project);

    @Select("select * from outsourcinguserinfo where phone=#{phone}")
    List<OutsourcingUserInfo> getAllOutsourcingUserInfoByPhone(@Param("phone") String phone);

    @Update("update outsourcinguserinfo set name=#{name},gender=#{gender} where phone=#{phone}")
    void updateAllNameAndGenderBuPhone(OutsourcingUserInfo outsourcingUserInfo);
}
