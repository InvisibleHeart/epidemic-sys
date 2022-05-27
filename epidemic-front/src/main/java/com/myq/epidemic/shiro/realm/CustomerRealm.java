package com.myq.epidemic.shiro.realm;

import com.myq.epidemic.common.model.ResponseVO;
import com.myq.epidemic.setting.interfaces.UserInformationInterface;
import com.myq.epidemic.setting.model.dto.TokenDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private UserInformationInterface userInformationInterface;

    //  授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    //  认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = String.valueOf(authenticationToken.getPrincipal());
        String passWord = String.valueOf(authenticationToken.getCredentials());
        log.info("请求登陆用户名: ---> {}", userName);
        TokenDTO dto = new TokenDTO();
        dto.setUserName(userName);
        //  获取正确结果
        TokenDTO token = userInformationInterface.userSelectOne(dto).getData();
        if (token == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        if (passWord == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        if (token.getUserName().equals(userName)) {
            return new SimpleAuthenticationInfo(token.getUserName(), token.getPassWord(), this.getName());
        }
        return null;
    }
}
