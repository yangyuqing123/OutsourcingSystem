package com.zhy.controller.employer.staffquery;

import com.zhy.model.outsourcing.OutsourcingUserInfo;
import com.zhy.service.mybatis.OutsourcingUserInfoService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

/**
 * @author: zhangocean
 * @Date: Created in 19:04 2018/3/24
 * Describe: 人员信息查询与维护
 */
@Controller
public class GetOutsourcingUserInfo {

    @Autowired
    OutsourcingUserInfoService outsourcingUserInfoService;

    @PostMapping("/getOutsourcingUserInfo")
    @ResponseBody
    public JSONArray getOutsourcingUserInfo(@AuthenticationPrincipal Principal principal){

        List<OutsourcingUserInfo> outsourcingUserInfoList = outsourcingUserInfoService.selectAllOutsourcingUserInfoByMangerPhone(principal.getName());
        JSONArray jsonArray = JSONArray.fromObject(outsourcingUserInfoList);
        System.out.println("外包人员信息登记表：" + jsonArray);

        return jsonArray;
    }

}
