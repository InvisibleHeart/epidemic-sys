package com.myq.epidemic.shiro.freemarker;

/**
 * <p>Equivalent to {@link org.apache.shiro.web.tags.HasPermissionTag}</p>
 *
 * @since 0.1
 */
public class HasPermissionTag extends PermissionTag {

    @Override
    protected boolean showTagBody(String p) {
        return isPermitted(p);
    }
}
