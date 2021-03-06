package com.zhy.service.mybatis;

import com.zhy.model.taskfollow.OrgZTree;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zhangocean
 * @Date: Created in 15:34 2018/4/1
 * Describe: 查询 ZTree 树
 */
@Service
public interface OrgZTreeService {

    /**
     * 查询树的所有根节点
     * @return 所有的根节点
     */
    List<OrgZTree> getRootNode(String phone);

    /**
     * 查询父节点下的所有子节点
     * @param pid 父节点
     * @return 父节点下的所有子节点
     */
    List<OrgZTree> getChildNode(int pid);

    /**
     * 查询所有的外包名
     * @return 所有的外包名
     */
    List<String> getAllOutsourcingName();

    /**
     * 保存节点信息
     * @param orgZTree
     */
    void saveOrgTree(OrgZTree orgZTree);

    /**
     * 通过外包名查找外包id
     * @param name 外包名
     * @return 外包id
     */
    int selectIdByOutsourcingName(String name);

    /**
     * 通过pid和手机号查找id
     * @param pid
     * @return id
     */
    int selectIdByPidAndPhone(int pid, String phone);

}
